
public class Searching {
	
	/**
	 * This method performs a binary search on a sorted array. The algorithm runs in O(log(n)).
	 * @param array - Array in which to search for a value.
	 * @param value - Value to find in Array
	 * @return - Arrayindex of the value searched for. Returns -1 if value has not been found.
	 */

	public static int binarySearch(int[] array, int value) {
		int left = 0;
		int right = array.length - 1;
		int middle = -1;
		
		while (left <= right) {
			middle = (left + right) / 2;
			if (array[middle] == value) {
				return middle;
			} else if (array[middle] > value) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}
	
	//test
}
