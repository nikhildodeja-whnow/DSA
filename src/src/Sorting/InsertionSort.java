package Sorting;

/*
 * Insertion Sort
 *
 * Problem:
 * Sort an array in ascending order using Insertion Sort.
 *
 * Approach:
 * - Assume the first element is already sorted.
 * - Pick the next element as the key.
 * - Compare the key with elements on its left.
 * - Shift larger elements one position to the right.
 * - Insert the key at its correct position.
 *
 * Example:
 *
 * Input:
 * [5, 3, 8, 1, 2]
 *
 * Output:
 * [1, 2, 3, 5, 8]
 *
 * Time Complexity:
 * Best Case    -> O(n)
 * Average Case -> O(n²)
 * Worst Case   -> O(n²)
 *
 * Space Complexity:
 * O(1)
 *
 * Sorting is done in-place.
 */

public class InsertionSort {

    public static void sort(int[] arr) {

        // Start from the second element
        for (int i = 1; i < arr.length; i++) {

            // Element that we want to insert
            int key = arr[i];

            // Start comparing with the previous element
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];

                j--;
            }

            // Insert key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 2};

        System.out.println("Before sorting:");
        System.out.println(java.util.Arrays.toString(arr));

        sort(arr);

        System.out.println("After sorting:");
        System.out.println(java.util.Arrays.toString(arr));
    }
}