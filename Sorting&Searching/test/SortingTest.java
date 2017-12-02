import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;



public class SortingTest {
	
	final int ARRAY_LENGTH = 100000;
	final int SWICHES = ARRAY_LENGTH * 100;
	
	int[] input = createSortedArray(ARRAY_LENGTH);
	int[] output = createSortedArray(ARRAY_LENGTH);
	

	
	@Test
	public void mergeSortTest() {
		
		shuffleArray(input, SWICHES);
		
		Sorting.mergeSort(input, 0, input.length - 1);
		assertTrue(Arrays.equals(output, input));
	}
	
	@Test
	public void heapSortTest() {

		shuffleArray(input, SWICHES);
		
		Sorting.heapSort(input);
		assertTrue(Arrays.equals(output, input));
	}
	
	@Test
	public void quickSortTest() {

		int[] input1 = {1, 3, 5, 4, 6, 2, 7, 9, 8};
		int[] output1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		Sorting.quickSort(input1, 0, input1.length - 1);
		assertTrue(Arrays.equals(output1, input1));
	}
	
	public static int[] createSortedArray(int size) {
		int[] array = new int[size];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		return array;
	}
	
	public static void shuffleArray(int[] array, int switches) {
		Random random = new Random();
		for (int i = 0; i < switches; i++) {
			int e1 = random.nextInt(array.length);
			int e2 = random.nextInt(array.length);
			
			int temp = array[e1];
			array[e1] = array[e2];
			array[e2] = temp;
		}
	}
}
