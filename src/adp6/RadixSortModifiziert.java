package adp6;

public class RadixSortModifiziert {

	private long counter;

	/**
	 * Das Array arr[] mit der größe arrayLength wird mit RadixSort sortiert.
	 * maxZiffernAnzahl wurde so modifiziert, dass die erste Zahl irrelevant
	 * ist, da die zu sortierende Werte im Bereich 700*arrayLength <= key <
	 * 800*arrayLength sind. Alle Werte fangen mit 7 an.
	 * 
	 * Der Aufwand ist immer ziffernAnzahl*(2*arrayLength)+ziffernAnzahl*10
	 * Komplexität 0(n)
	 * 
	 * @param arr
	 * @param arrayLength
	 * @return
	 */
	int[] radixsort(int arr[], int arrayLength) {
		// die Zifferanzahl des ergebnisses repräsentiert die Zifferanzahl der
		// relevanten ziffern
		int maxZiffernAnzahl = arrayLength * 10;

		// Nur für die Relevanten Ziffern Countsort Aufrufen
		// Beispiel N=1 7000-7999 erste Zahl ist irrelevant also nur die letzten
		// 3 Ziffern müssen sortiert werden
		// die for Schleife wird nur 3 mal aufgerufen
		for (int zifferStelle = 1; maxZiffernAnzahl / zifferStelle > 0; zifferStelle *= 10) {
			counter++;
			arr = countSort(arr, arrayLength, zifferStelle);
		}
		return arr;
	}

	int[] countSort(int arr[], int n, int ziffernStelle) {
		// das Output array
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		// Häufigkeit des Auftretens einer Zahl im Count array
		for (i = 0; i < n; i++) {
			counter++;
			count[(arr[i] / ziffernStelle) % 10]++;
		}
		// count[i] wird so addiert, dass count[i] die eigentliche Position von
		// der letzten dieser Zahl im Outputarray entspricht
		for (i = 1; i < 10; i++) {
			counter++;
			count[i] += count[i - 1];
		}
		// Schreibt Die zahl arr[i] ins output array an der platz den wir im
		// count array gespeichert haben
		// und decrementieren dann den countarray an dieser stelle um 1
		for (i = n - 1; i >= 0; i--) {
			counter++;
			output[count[(arr[i] / ziffernStelle) % 10] - 1] = arr[i];
			// dekrementieren damit die Repräsentation des Indexes im
			// Outputarray mit der Anordnung übereinstimmt
			count[(arr[i] / ziffernStelle) % 10]--;
		}
		
		//Array wird direkt zurückgegeben
		return output;
	}

	long getCounter() {
		return counter;
	}

	void setCounter(int counterZahl) {
		counter = counterZahl;
	}

}