
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
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
			i = j;
		}
	}
	
	
	public static void quickSort(int[] A, int l, int r) {
		if (l < r) {
			int k = partition(A, l, r);
			quickSort(A, l, k - 1);
			quickSort(A, k + 1, r);
		}
	}
	
	private static int partition(int[] A, int l, int r) {
		int i = l;
		int j = r - l;
		int p = A[r];
		
		do {
			while (i < r && A[i] < p) {
				i++;
			}
			while (j > l && A[j] > p) {
				j--;
			}
			if (i < j) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		} while (i < j);
		
		
		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		
		return i;
	}
	
	
	
}
