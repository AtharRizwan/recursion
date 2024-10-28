package string_perms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

/*
 * Testing Strategy:
 * str.length(): 0, 1, > 1
 * perms.size(): 0, 1, > 1	
 * duplicates: true, false
*/
class StringPermutationTest {
	// Covers: str.length() = 0, perms.size() = 1, duplicates = true
    @Test
    void testEmptyString() {
        // Test with an empty string
        List<String> result = StringPermutation.permute("", true);
        assertEquals(0, result.size());
    }

	// Covers: str.length() = 1, perms.size() = 1, duplicates = true
    @Test
    void testSingleCharacter() {
        // Test with a single-character string
        List<String> result = StringPermutation.permute("A", true);
        assertEquals(1, result.size());
		assertEquals("A", result.get(0));
	}

	// Covers: str.length() > 1, perms.size() > 1, duplicates = true
    @Test
    void testMultipleCharactersWithDuplicatesAllowed() {
        // Test with a two-character string allowing duplicates
        List<String> result = StringPermutation.permute("AA", true);
        assertEquals(2, result.size());
        assertEquals("AA", result.get(0));
        assertEquals("AA", result.get(1));
    }

	// Covers: str.length() > 1, perms.size() = 1, duplicates = false
    @Test
    void testMultipleCharactersNoDuplicates() {
        // Test with a two-character string not allowing duplicates
        List<String> result = StringPermutation.permute("AA", false);
        assertEquals(1, result.size());
        assertEquals("AA", result.get(0));
    }
}