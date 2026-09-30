package Sorting;

/*
 * Selection Sort
 *
 * Problem:
 * Sort an array in ascending order using Selection Sort.
 *
 * Approach:
 * 1. Assume current position has the minimum element.
 * 2. Search the remaining unsorted array.
 * 3. Find the actual minimum element.
 * 4. Swap it with the current position.
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
 * Best Case    -> O(n²)
 * Average Case -> O(n²)
 * Worst Case   -> O(n²)
 *
 * Space Complexity:
 * O(1)
 *
 * Sorting is done in-place.
 */

public class SelectionSort1 {

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            // Assume current position has the minimum element
            int minIndex = i;

            // Find minimum element in the remaining array
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap current element with minimum element
            if (minIndex != i) {

                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
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