import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SortingTest {

	
	
	@Test
	public void mergeSortTest() {
		
		int[] output = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] input = {2, 5, 3, 7, 4, 9, 8, 1, 0, 6};
		Sorting.mergeSort(input, 0, input.length - 1);
		assertTrue(Arrays.equals(output, input));


	}
}
