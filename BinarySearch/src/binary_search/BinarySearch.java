package binary_search;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Binary search is a search algorithm that finds the position of a target value within a sorted array.
 */
public class BinarySearch {
    /**
     * Find the position of the target value within a sorted array using binary search.
     * @param list the sorted list of integers
     * @param target the target value to search for
     * @return the index of the target value in the list, or -1 if the target value is not found
     * @throws IllegalArgumentException if the input list is null
     */
    public static int binarySearchRecursive(List<Integer> list, int target) {
        if (list == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return binarySearchRecursive(list, target, 0, list.size() - 1);
    }

    /**
     * Recursively performs binary search on a sublist defined by start and end indices.
     * @param list the sorted list of integers
     * @param target the target value to search for
     * @param start the starting index of the sublist
     * @param end the ending index of the sublist
     * @return the index of the target value within the sublist, or -1 if not found
     */
    private static int binarySearchRecursive(List<Integer> list, int target, int start, int end) {
        // Base case: start index is greater than end index
        if (start > end) {
            return -1;
        }

        // Find the middle index of the sublist
        int mid = start + (end - start) / 2;

        // Recursively search the left or right sublist
        if (list.get(mid) == target) {
            return mid;
        } else if (target < list.get(mid)) {
            return binarySearchRecursive(list, target, start, mid - 1);
        } else {
            return binarySearchRecursive(list, target, mid + 1, end);
        }        
    }

    /**
     * Recursively performs binary search on a list of strings
     * @param list the sorted list of strings
     * @param target the target value to search for
     * @return the index of the target value in the list, or "-1" if the target value is not found
     * @throws IllegalArgumentException if the input list is null
     */
    public static int binarySearchRecursiveString(List<String> list, String target) {
        if (list == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return binarySearchRecursiveString(list, target, 0, list.size() - 1);
    }

    /**
     * Recursively performs binary search on a sublist defined by start and end indices.
     * @param list the sorted list of strings
     * @param target the target value to search for
     * @param start the starting index of the sublist
     * @param end the ending index of the sublist
     * @return the index of the target value within the sublist, or -1 if not found
     */
    private static int binarySearchRecursiveString(List<String> list, String target, int start, int end) {
        // Base case: start index is greater than end index
        if (start > end) {
            return -1;
        }

        // Find the middle index of the sublist
        int mid = start + (end - start) / 2;

        // Recursively search the left or right sublist
        if (list.get(mid).equals(target)) {
            return mid;
        } else if (target.compareTo(list.get(mid)) < 0) {
            return binarySearchRecursiveString(list, target, start, mid - 1);
        } else {
            return binarySearchRecursiveString(list, target, mid + 1, end);
        }
    }

    /**
     * Returns the indices of all integers that match target
     * @param list the sorted list of integers
     * @param target the target value to search for
     * @return the list of indices of the target value in the list, or an empty list if the target value is not found
     * @throws IllegalArgumentException if the input list is null
     */
    public static List<Integer> binarySearchAll(List<Integer> list, int target) {
        if (list == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return binarySearchAll(list, target, 0, list.size() - 1);
    }

    /**
     * Recursively performs binary search on a sublist defined by start and end indices.
     * @param list the sorted list of integers
     * @param target the target value to search for
     * @param start the starting index of the sublist
     * @param end the ending index of the sublist
     * @return the list of indices of the target value within the sublist, or an empty list if not found
     */
    private static List<Integer> binarySearchAll(List<Integer> list, int target, int start, int end) {
        // Base case: start index is greater than end index
        if (start > end) {
            return new ArrayList<>();
        }

        // Find the middle index of the sublist
        int mid = start + (end - start) / 2;

        // Recursively search the left or right sublist
        if (list.get(mid) == target) {
            List<Integer> result = new ArrayList<>();
            result.add(mid);

            // Search left sublist
            int left = mid - 1;
            while (left >= start && list.get(left) == target) {
                result.add(left);
                left--;
            }

            // Search right sublist
            int right = mid + 1;
            while (right <= end && list.get(right) == target) {
                result.add(right);
                right++;
            }

            return result;
        } else if (target < list.get(mid)) {
            return binarySearchAll(list, target, start, mid - 1);
        } else {
            return binarySearchAll(list, target, mid + 1, end);
        }
    }

    /**
     * Main method to test the binary search algorithm.
     * @param args the command line arguments, unused
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the sorted list
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.print("Enter " + n + " sorted integers: ");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        // Check if the array is actually sorted 
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                System.out.println("The list is not sorted.");
                return;
            }
        }

        // Take the target value
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Perform binary search and display result
        int result = binarySearchRecursive(list, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the list.");
        }

        scanner.close();
    }
}
