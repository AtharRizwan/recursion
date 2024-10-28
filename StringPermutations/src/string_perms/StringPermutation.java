package string_perms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutation {
    /*
     * @param str: The string to permute
     * @param duplicates: Whether to allow duplicates in the permutations   
     * @return A list of all permutations of the string
     */
    public static List<String> permute(String str, boolean duplicates) {
        List<String> perms = new ArrayList<String>();

        // Empty String
        if (str == null || str.isEmpty()) {
            return perms;
        }

        // Helper function
        permuteHelper(new StringBuilder(str), 0, perms);

        if (!duplicates) {
            removeDuplicates(perms);
        }

        // Sort the List
        perms.sort(null);
        return perms;
    }

    private static void permuteHelper(StringBuilder str, int index, List<String> perms) {
        // Base case: if we've reached the end, add the permutation
        if (index == str.length()) {
            perms.add(str.toString());
            return;
        }

        // Recursive case: generate permutations by swapping
        for (int i = index; i < str.length(); i++) {
            swap(str, index, i);
            permuteHelper(str, index + 1, perms);
            swap(str, index, i);
        }
    }

    private static void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    private static void removeDuplicates(List<String> perms) {
        // Use a Set to filter duplicates
        Set<String> uniquePerms = new HashSet<>(perms);
        
        // Clear the original list and add all unique elements
        perms.clear();
        perms.addAll(uniquePerms);
    }
}
