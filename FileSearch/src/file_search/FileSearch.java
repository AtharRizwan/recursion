package file_search;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileSearch {
    /*
    * @param dir: a string - the directory to search in
    * @param fileStrings: an array of Strings - the files to Search for
    * @param case_sensitive: a boolean - whether the search is case sensitive
    * @return: a map of Strings to Integers - the files found and the number of times they were found
    */
    public static Map<String, Integer> search(String dir, String[] fileStrings, boolean case_sensitive) {
        // Initialize the map with the count of each file set to 0
        Map<String, Integer> file_count = new HashMap<>();
        for (String file : fileStrings) {
            file_count.put(case_sensitive ? file : file.toLowerCase(), 0);
        }

        // Check if directory path is valid
        if (dir == null || dir.isEmpty()) {
            return file_count;
        }
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            return file_count;
        }

        // Recursive helper method to search directories
        searchDirectory(directory, file_count, case_sensitive);

        return file_count;
    }

    private static void searchDirectory(File directory, Map<String, Integer> file_count, boolean case_sensitive) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
    
        for (File f : files) {
            if (f.isFile()) {
                String filename = case_sensitive ? f.getName() : f.getName().toLowerCase();
                // Only increment count if filename is in the file_count map
                if (file_count.containsKey(filename)) {
                    file_count.put(filename, file_count.get(filename) + 1);
                }
            } else if (f.isDirectory()) {
                // Recurse into subdirectory
                searchDirectory(f, file_count, case_sensitive);
            }
        }
    }
}