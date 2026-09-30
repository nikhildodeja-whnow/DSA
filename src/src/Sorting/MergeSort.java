package Sorting;

/*
 * Merge Sort
 *
 * Problem:
 * Sort an array in ascending order using Merge Sort.
 *
 * Approach:
 *
 * 1. Divide:
 *    - Divide the array into two halves.
 *    - Keep dividing until each part contains one element.
 *
 * 2. Merge:
 *    - Merge two sorted parts.
 *    - Compare the front elements of both parts.
 *    - Put the smaller element into the temporary array.
 *    - When one side is finished, copy the remaining elements.
 *
 * Example:
 *
 * Input:
 * [8, 3, 5, 1, 4, 2]
 *
 * Divide:
 * [8, 3, 5]   [1, 4, 2]
 *
 * Further divide:
 * [8] [3] [5]   [1] [4] [2]
 *
 * Merge:
 * [3, 5]        [2, 4]
 *
 * Merge:
 * [3, 5, 8]     [1, 2, 4]
 *
 * Final merge:
 * [1, 2, 3, 4, 5, 8]
 *
 * Time Complexity:
 * Best Case    -> O(n log n)
 * Average Case -> O(n log n)
 * Worst Case   -> O(n log n)
 *
 * Space Complexity:
 * O(n)
 *
 * Merge Sort uses extra temporary array space.
 */

public class MergeSort {

    public static void sort(int[] arr) {

        // Base case:
        // If array has 0 or 1 element, it is already sorted.
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        // Create left and right arrays
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copy elements into left array
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        // Copy elements into right array
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // Sort left half
        sort(left);

        // Sort right half
        sort(right);

        // Merge both sorted halves back into arr
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {

        int i = 0; // pointer for left array
        int j = 0; // pointer for right array
        int k = 0; // pointer for original array

        // Compare elements from left and right arrays
        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {

                arr[k] = left[i];
                i++;

            } else {

                arr[k] = right[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from left array
        while (i < left.length) {

            arr[k] = left[i];

            i++;
            k++;
        }

        // Copy remaining elements from right array
        while (j < right.length) {

            arr[k] = right[j];

            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 1, 2};

        System.out.println("Before sorting:");
        System.out.println(java.util.Arrays.toString(arr));

        sort(arr);

        System.out.println("After sorting:");
        System.out.println(java.util.Arrays.toString(arr));
    }
}