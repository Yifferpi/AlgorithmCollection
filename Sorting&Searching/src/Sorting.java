
public class Sorting {

	/**
	 * This method performs a mergeSort on an unsorted array. The algorithm runs in O(n*log(n)).
	 * @param array - Unsorted array to be sorted
	 * @param indexLeft - Left border from where to start (usually 0)
	 * @param indexRight - Right border from where to start (usually array.length - 1)
	 */
	
	public static void mergeSort(int[] array, int indexLeft, int indexRight) {
		int indexMiddle = (indexLeft + indexRight) / 2;
		if (indexLeft < indexRight) {
			mergeSort(array, indexLeft, indexMiddle);
			mergeSort(array, indexMiddle + 1, indexRight);
			merge(array, indexLeft, indexMiddle, indexRight);	
		}
	}
	private static void merge(int[] A, int indexLeft, int indexMiddle, int indexRight) {
		int[] B = new int[indexRight - indexLeft + 1];
		int i = indexLeft;
		int j = indexMiddle + 1;
		int k = 0;		
		while (i <= indexMiddle && j <= indexRight) {
			if (A[i] <= A[j]) {
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j++;
			}
			k++;
		}
		while (i <= indexMiddle) {
			B[k] = A[i];
			i++;
			k++;
		}
		while (j <= indexRight) {
			B[k] = A[j];
			j++;
			k++;
		}
		for (k = indexLeft; k <= indexRight; k++) {
			A[k] = B[k - indexLeft ];
		}
	}

	public static void quickSort() {
		
	}
}
