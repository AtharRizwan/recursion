package file_search;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

/*
 * Testing Strategy
 * dir.length(): 0, 1, >1
 * fileStrings.size(): 0, 1, >1
 * case sensitive: false, true
 * Number of files existing in the directory: 0, 1, >1
 * Count of each file in the directory: 0, 1, >1
 */
public class FileSearchTest {
    // Test case: Directory does not exist
    // dir.length(): 1, fileStrings.size(): 0, case_sensitive: false, no files to find
    @Test
    public void testNonExistentDirectory() {
        String dir = "nonexistent";
        String[] fileStrings = {};
        boolean case_sensitive = false;

        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> actual = FileSearch.search(dir, fileStrings, case_sensitive);

        assertEquals(expected, actual, "Expected an empty map for a non-existent directory.");
    }

    // Test case: Empty directory with files to search for
    // dir.length() > 1, fileStrings.size(): 1, case_sensitive: false, directory exists but is empty
    @Test
    public void testEmptyDirectoryWithFiles() {
        String dir = "test_dirs/empty";
        String[] fileStrings = {"file1.txt"};
        boolean case_sensitive = false;

        Map<String, Integer> expected = Map.of("file1.txt", 0);
        Map<String, Integer> actual = FileSearch.search(dir, fileStrings, case_sensitive);

        assertEquals(expected, actual, "Expected all counts to be zero in an empty directory.");
    }

    // Test case: Directory with a single file matching the search
    // dir.length() > 1, fileStrings.size(): 1, case_sensitive: true, directory contains one matching file
    @Test
    public void testSingleFileMatchCaseSensitive() {
        String dir = "test_dirs/full";
        String[] fileStrings = {"file1.txt"};
        boolean case_sensitive = true;

        Map<String, Integer> expected = Map.of("file1.txt", 1);
        Map<String, Integer> actual = FileSearch.search(dir, fileStrings, case_sensitive);

        assertEquals(expected, actual, "Expected count to be 1 for 'testfile.txt' in case-sensitive search.");
    }

    // Test case: Directory with multiple files, including case variations
    // dir.length() > 1, fileStrings.size(): 2, case_sensitive: false, directory contains files with case variations
    @Test
    public void testMultipleFilesCaseInsensitive() {
        String dir = "test_dirs/full";
        String[] fileStrings = {"file1.txt", "File2.txt"};
        boolean case_sensitive = false;

        Map<String, Integer> expected = Map.of("file1.txt", 1, "file2.txt", 1);
        Map<String, Integer> actual = FileSearch.search(dir, fileStrings, case_sensitive);

        assertEquals(expected, actual, "Expected count to be case-insensitive and aggregate similar files.");
    }

    // Test case: Directory with no matching files
    // dir.length() > 1, fileStrings.size(): >1, case_sensitive: false, directory has files but none match
    @Test
    public void testNoMatchingFiles() {
        String dir = "test_dirs/unrelated";
        String[] fileStrings = {"file1.txt", "file2.txt"};
        boolean case_sensitive = false;

        Map<String, Integer> expected = Map.of("file1.txt", 0, "file2.txt", 0);
        Map<String, Integer> actual = FileSearch.search(dir, fileStrings, case_sensitive);

        assertEquals(expected, actual, "Expected all counts to be zero for non-matching files.");
    }

    // Test case: Directory with multiple subdirectories, searching for files recursively
    // dir.length() > 1, fileStrings.size(): 1, case_sensitive: true, files distributed across subdirectories
    @Test
    public void testRecursiveFileSearch() {
        String dir = "test_dirs";
        String[] fileStrings = {"file1.txt"};
        boolean case_sensitive = true;

        Map<String, Integer> expected = Map.of("file1.txt", 2);
        Map<String, Integer> actual = FileSearch.search(dir, fileStrings, case_sensitive);

        assertEquals(expected, actual, "Expected count to reflect occurrences across subdirectories.");
    }
}