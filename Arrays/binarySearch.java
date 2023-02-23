package Arrays;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        // Test the binary search algorithm
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;
        int index = binarySearch(array, key);
        System.out.println("Key " + key + " found at index " + index);
    }

    public static int binarySearch(int[] array, int key) {
        // Sort the array in ascending order
        Arrays.sort(array);

        // Set the bounds of the search
        int low = 0;
        int high = array.length - 1;

        // Perform the binary search
        while (low <= high) {
            // Calculate the midpoint of the search
            int mid = low + (high - low) / 2;

            // Compare the key to the element at the midpoint
            if (key < array[mid]) {
                // Search the left half
                high = mid - 1;
            } else if (key > array[mid]) {
                // Search the right half
                low = mid + 1;
            } else {
                // Key found
                return mid;
            }
        }

        // Key not found
        return -1;
    }
}
