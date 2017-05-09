package adp6;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestClassSchnellesSortieren {
	
	@Test
	public void sortieren(){
		int[] zahlen10Vergleich = new int [100];
		int[] zahlen10 = new int[100];
		gleichmaessigBefuellen(3, zahlen10Vergleich);
		System.arraycopy(zahlen10Vergleich, 0, zahlen10, 0, zahlen10Vergleich.length);
		gleichmaessigBefuellenZufall(3, zahlen10);
		
		RadixSortModifiziert sorter1 = new RadixSortModifiziert();
		
		zahlen10 = sorter1.radixsort(zahlen10, zahlen10.length);
		for(int i = 0; i < zahlen10.length-1; i++){
		assertEquals(zahlen10Vergleich[i], zahlen10[i]);
		}	
	}
	
	private static void gleichmaessigBefuellen(int k, int[] elemente) {
        int beginning = 700 * (int) Math.pow(10, k);
        for (int i = 0; i < elemente.length; i++) {
            elemente[i] = (int) (beginning + (100 * i) + (Math.random() * 100));
        }
    }
	
	public static void gleichmaessigBefuellenZufall(int k, int[] elemente) {
        int index, temp;
        Random random = new Random();
        for (int i = elemente.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = elemente[index];
            elemente[index] = elemente[i];
            elemente[i] = temp;
        }
	}

}
