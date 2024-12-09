package recursive_parser;

import jdk.jshell.EvalException;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing Strategy
 * - Expression is null
 * - Expression is empty
 * - Expression is a single number
 * - Expression contains only addition
 * - Expression contains only subtraction
 * - Expression contains only multiplication
 * - Expression contains only division
 * - Expression contains multiple operators
 * - Expression contains invalid characters
 * - Expression contains invalid operators
 * - Expression contains integers
 * - Expression contains floating point numbers
 */
public class RecursiveParserTest {

	@Test
	public void testNullExpression() {
		try {
			RecursiveParser.evaluateExpression(null);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid expression!", e.getMessage());
		}
	}

	@Test 
	public void testEmptyExpression() {
		try {
			RecursiveParser.evaluateExpression("");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("empty String", e.getMessage());
		}
	}

	@Test
	public void testSingleNumber() {
		assertEquals(5.0, RecursiveParser.evaluateExpression("5"), 0.0);
		assertEquals(8.3, RecursiveParser.evaluateExpression("8.3"), 0.0);
	}

	@Test
	public void testAddition() {
		assertEquals(5.0, RecursiveParser.evaluateExpression("2+3"), 0.0);
		assertEquals(8.1, RecursiveParser.evaluateExpression("2.3+5.8"), 0.0);
	}

	@Test
	public void testSubtraction() {
		assertEquals(5.0, RecursiveParser.evaluateExpression("8-3"), 0.0);
		assertEquals(2.3, RecursiveParser.evaluateExpression("8.1-5.8"), 0.0);
	}

	@Test
	public void testMultiplication() {
		assertEquals(6.0, RecursiveParser.evaluateExpression("2*3"), 0.0);
		assertEquals(17.5, RecursiveParser.evaluateExpression("3.5*5"), 0.0);
	}

	@Test
	public void testDivision() {
		assertEquals(2.0, RecursiveParser.evaluateExpression("6/3"), 0.0);
		try {
			RecursiveParser.evaluateExpression("5/0");
		} catch (Exception e) {
			assertEquals("Division by zero!", e.getMessage());
		}
		assertEquals(2.5, RecursiveParser.evaluateExpression("5/2"), 0.0);
	}

	@Test
	public void testMultipleOperators() {
		assertEquals(8.0, RecursiveParser.evaluateExpression("2+3*2"), 0.0);
	}

	@Test
	public void testInvalidCharacters() {
		try {
			RecursiveParser.evaluateExpression("2+3a");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("For input string: \"3a\"", e.getMessage());
		}
	}

	@Test
	public void testInvalidOperators() {
		try {
			RecursiveParser.evaluateExpression("2^3");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("For input string: \"2^3\"", e.getMessage());
		}
	}
}
