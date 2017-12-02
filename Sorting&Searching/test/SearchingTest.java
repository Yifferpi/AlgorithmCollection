import static org.junit.Assert.*;
import org.junit.Test;


public class SearchingTest {

	
	
	@Test
	public void binarySearchTest() {
		int[] input = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		assertEquals(3, Searching.binarySearch(input, 40));
		assertEquals(7, Searching.binarySearch(input, 80));
		assertEquals(5, Searching.binarySearch(input, 60));
		assertEquals(0, Searching.binarySearch(input, 10));
		assertEquals(9, Searching.binarySearch(input, 100));
		
		assertEquals(-1, Searching.binarySearch(input, 55));
		assertEquals(-1, Searching.binarySearch(input, 1));

	}
}
