
public class Sorting {
	
	//==============================================================================================
	
	/**
	 * This method performs a mergeSort on an unsorted array. The algorithm runs in O(n*log(n)).
	 * (This Implementation of MergeSort runs on Indices alone..)
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

	//==============================================================================================
	
	/**
	 * This method performs a heapSort on an unsorted array. The algorithm runs in O(n*log(n)).
	 * @param A - Unsorted array to be sorted
	 */
	
	public static void heapSort(int[] A) {
		int n = A.length - 1;
		int i = n/2;
		
		while (i >= 0) {
			restoreHeapCondition(A, i, n);
			i--;
		}
		
		int m = n;
		while (m >= 1) {
			int temp = A[0];
			A[0] = A[m];
			A[m] = temp;
			restoreHeapCondition(A, 0, m - 1);
			m--;
		}
		
	}
	
	private static void restoreHeapCondition(int[] A, int i, int m) {
	
		while (2*i <= m) {
			int j = 2*i;
			if (j+1 <= m) {
				if (A[j] < A[j+1]) {
					j = j + 1;
				}
			}
			if (A[i] >= A[j]) {
				break;
			}
			else {
				exchange(A, i, j);
			}
			i = j;
		}
	}
	
	//==============================================================================================
	
	/**
	 * This method performs a quickSort on an unsorted array. The algorithm runs in O(n^2).
	 * @param A - Unsorted array to be sorted.
	 * @param l - Left border from where to start (usually 0)
	 * @param r - Right border from where to start (usually array.length - 1)
	 */
	
	public static void quickSort(int[] A, int l, int r) {
		if (l < r) {
			int k = partition(A, l, r);
			quickSort(A, l, k - 1);
			quickSort(A, k + 1, r);
		}
	}
	
	private static int partition(int[] A, int l, int r) {
		int i = l;
		int j = r - 1;
		int p = A[r];
		
		do {
			while (i < r && A[i] < p) {
				i++;
			}
			while (j > l && A[j] > p) {
				j--;
			}
			if (i < j) {
				exchange(A, i, j);
			}
		} while (i < j);

		exchange(A, i, r);
		
		return i;
	}

	//==============================================================================================

	/**
	 * This method performs a bubbleSort on an unsorted array. The algorithm runs in O(n^2).
	 * @param A - Unsorted array to be sorted.
	 */
	
	public static void bubbleSort(int[] A) {
		for (int n = A.length - 1; n >= 0; n--) {
			for (int i = 0; i <= n - 1; i++) {
				if (A[i] > A[i + 1]) {
					exchange(A, i, i + 1);
				}
			}
		}
	}
	
	//==============================================================================================

	/**
	 * This method performs a selectionSort on an unsorted array. The algorithm runs in O(n^2).
	 * @param A - Unsorted array to be sorted.
	 */
	
	public static void selectionSort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int min = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[min]) {
					min = j;
				}
			}
			exchange(A, min, i);
		}		
	}
	
	//==============================================================================================

	/**
	 * This method performs an insertionSort on an unsorted array. The algorithm runs in O(n^2).
	 * @param A - Unsorted array to be sorted.
	 */
	
	public static void insertionSort(int[] A) {
		for (int i = 2; i < A.length; i++) {
			int insert = A[i];
			int j = i;
			while (j > 0 && A[j-1] > insert) {
				A[j] = A[j - 1];
				j--;
			}
			A[j] = insert;
		}
	}
	
	//==============================================================================================
	//private functions used in several algorithms:
	
	private static void exchange(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
}
