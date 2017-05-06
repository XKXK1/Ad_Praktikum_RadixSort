package adp6;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestClassSchnellesSortieren {
	
	@Test
	public void sortieren(){
		int[] zahlen10Vergleich = new int [10];
		int[] zahlen10 = new int[10];
		spezialBefuellt(1, zahlen10Vergleich);
		System.arraycopy(zahlen10Vergleich, 0, zahlen10, 0, zahlen10Vergleich.length);
		spezialZufaellig(1, zahlen10);
		
		RadixSort sorter1 = new RadixSort();
		
		zahlen10 = sorter1.sortFast(zahlen10.length, zahlen10);
		for(int i = 0; i < zahlen10.length-1; i++){
		assertEquals(zahlen10Vergleich[i], zahlen10[i]);
		}	
	}
	
	private static void spezialBefuellt(int k, int[] elemente) {
        int beginning = 700 * (int) Math.pow(10, k);
        for (int i = 0; i < elemente.length; i++) {
            elemente[i] = (int) (beginning + (100 * i) + (Math.random() * 100));
        }
    }
	
	public static void spezialZufaellig(int k, int[] elemente) {
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
