package digit_sum;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing Strategy
 * - number is 1
 * - number is 0
 * - number is -1 
 * - number is > 1
 * - number is < -1
 * - number is the maximum int
 * - number is the minimum int
 */
public class DigitSumTest {
	@Test
	public void testSumOfDigits1() {
		assertEquals(1, DigitSum.sumOfDigits(1));
	}

	@Test
	public void testSumOfDigits0() {
		assertEquals(0, DigitSum.sumOfDigits(0));
	}

	@Test
	public void testSumOfDigitsNegative1() {
		assertEquals(1, DigitSum.sumOfDigits(-1));
	}

	@Test
	public void testSumOfDigitsPositive() {
		assertEquals(6, DigitSum.sumOfDigits(123));
	}

	@Test
	public void testSumOfDigitsNegative() {
		assertEquals(6, DigitSum.sumOfDigits(-123));
	}

	@Test
	public void testSumOfDigitsMaxInt() {
		assertEquals(46, DigitSum.sumOfDigits(Integer.MAX_VALUE));
	}

	@Test
	public void testSumOfDigitsMinInt() {
		assertEquals(31, DigitSum.sumOfDigits(Integer.MIN_VALUE));
	}
}
