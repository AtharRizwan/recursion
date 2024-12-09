package binary_search;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Strategy
 * - List is null
 * - List is empty
 * - List has one element
 * - List has multiple elements
 * - Target is at index 0
 * - Target is at last index
 * - Target is somewhere in the middle
 * - Target is not in the list
 */
public class BinarySearchTest {

	@Test
	public void testNullArray() {
		try {
			BinarySearch.binarySearchRecursive(null, 5);
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("Input list must not be null", e.getMessage());
		}
	}

	@Test
	public void testEmptyArray() {
		assertEquals(-1, BinarySearch.binarySearchRecursive(new ArrayList<>(), 5));
	}

	@Test
	public void testSingleElementArray() {
		assertEquals(0, BinarySearch.binarySearchRecursive(List.of(5), 5));
		assertEquals(-1, BinarySearch.binarySearchRecursive(List.of(5), 10));
	}

	@Test
	public void testMultipleElementArray() {
		assertEquals(0, BinarySearch.binarySearchRecursive(List.of(5, 10, 15, 20, 25), 5));
		assertEquals(4, BinarySearch.binarySearchRecursive(List.of(5, 10, 15, 20, 25), 25));
		assertEquals(2, BinarySearch.binarySearchRecursive(List.of(5, 10, 15, 20, 25), 15));
		assertEquals(-1, BinarySearch.binarySearchRecursive(List.of(5, 10, 15, 20, 25), 12));
	}
}
