import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;



public class SortingTest {
	
	final int ARRAY_LENGTH = 10000000;
	
	int[] input = new int[ARRAY_LENGTH];
	int[] output = new int[ARRAY_LENGTH];
	

	
	@Test
	public void mergeSortTest() {
		
		createSortedArray(input);
		createSortedArray(output);
		shuffleArray(input, 100000000);
		
		Sorting.mergeSort(input, 0, input.length - 1);
		assertTrue(Arrays.equals(output, input));
	}
	
	public static void createSortedArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
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
