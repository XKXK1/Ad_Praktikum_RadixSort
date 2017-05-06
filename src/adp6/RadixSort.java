package adp6;

import java.util.Arrays;

public class RadixSort {
	

	private long counter;

	
	 // A utility function to get maximum value in arr[]

 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m =10*n;
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        
        /*
         * 100 weil wir erst bei einer gewissen anzahl anfangen zu gucken, da wir das array so befüllt haben(gleichmaessig)
         * wissen wir, dass wir nicht alle zahlen checken muessen
         * m/exp wird gemacht, damit da m schneller steigt und dann muss geguckt werden ob noch mehr zahlen gecheckt werden müssen
         * falls ja wird der exp erhöht und ein weiterer durchgang wird gemacht
         * stellenwert wird erhöht, da die unterschiede sich auf zb mehrere stellenwerte verteilen
         */
        for (int exp = 100; m/exp > 0; exp *= 10){
        	counter++;
        	countSort(arr, n, exp);         
        }     
    }
    
    int[] sortFast(int n, int arr[]){
        int[] output = new int[n];
        int mod = 7*n;
        for(int i = 0; i < arr.length;i++){
            int index =(arr[i]/100)%mod;
            output[index] = arr[i];
            counter++;
        }
       return output;
        
    	
    }
    
     void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++){
        	counter++;
            count[ (arr[i]/exp)%10 ]++;
        }
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++){
        	counter++;
            count[i] += count[i - 1];
        }
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
        	counter++;
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++){
        	counter++;
            arr[i] = output[i];
        }
    }
    
    long getCounter(){
    	return counter;
    }
    
   void setCounter(int counterZahl){
    	counter = counterZahl;
    }
   
}