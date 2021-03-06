package adp6;

import java.util.Random;

import quicksort.Quicksort;


public class KomplexitaetsAnalyse {
	
	static void analyse(int exponent){
		int[] arrayRadix;
		int[] arrayQuicksort;
		Quicksort quicksort = new Quicksort();
		RadixSortModifiziert sorterRadix = new RadixSortModifiziert();
		
		arrayRadix = new int [(int)Math.pow(10, exponent)];
		arrayQuicksort = new int [(int)Math.pow(10, exponent)];
		gleichmaessigBefuellenZufall(exponent, arrayRadix);
		gleichmaessigBefuellenZufall(exponent, arrayQuicksort);
		
		arrayRadix = sorterRadix.radixsort(arrayRadix, arrayRadix.length);
		quicksort.quickSort(arrayQuicksort, 0, arrayQuicksort.length-1, 2);
		
		System.out.printf("\nradixsort bei N=%d braucht %d",exponent,sorterRadix.getCounter());
		System.out.printf("\nquicksort bei N=%d braucht %d",exponent,quicksort.getCounter());
		
		
	}
	
	
	
	private static void gleichmaessigBefuellen(int k, int[] elemente) {
        int beginning = 700 * (int) Math.pow(10, k);
        for (int i = 0; i < elemente.length; i++) {
            elemente[i] = (int) (beginning + (100 * i) + (Math.random() * 100));
        }
    }
	
	public static void gleichmaessigBefuellenZufall(int k, int[] elemente) {
        gleichmaessigBefuellen(k, elemente);
        int index, temp;
        Random random = new Random();
        for (int i = elemente.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = elemente[index];
            elemente[index] = elemente[i];
            elemente[i] = temp;
        }
	}
	

	public static void main(String[] args) {
		for(int i = 1; i <=6 ; i++){
			analyse(i);
		}
	}
}
