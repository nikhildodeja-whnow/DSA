package Sorting;

/*
 * Bubble Sort
 *
 * Problem:
 * Sort an array in ascending order using Bubble Sort.
 *
 * Approach:
 * - Compare adjacent elements.
 * - If the left element is greater than the right element,
 *   swap them.
 * - After every complete pass, the largest unsorted element
 *   moves to the end of the array.
 *
 * Example:
 *
 * Input:
 * [3, 8, 1, 4, 7]
 *
 * Output:
 * [1, 3, 4, 7, 8]
 *
 * Time Complexity:
 * Worst Case    -> O(n²)
 * Average Case  -> O(n²)
 * Best Case     -> O(n) with the swapped optimization
 *
 * Space Complexity:
 * O(1)
 *
 * The sorting is done in-place.
 */

public class BubbleSort {

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            boolean swapped = false;

            /*
             * Compare adjacent elements.
             *
             * arr[j] and arr[j + 1]
             *
             * The last i elements are already sorted,
             * so we don't need to check them again.
             */
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            /*
             * If no swap happened during this pass,
             * the array is already sorted.
             */
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 8, 1, 4, 7};

        System.out.println("Before sorting:");
        System.out.println(java.util.Arrays.toString(arr));

        sort(arr);

        System.out.println("After sorting:");
        System.out.println(java.util.Arrays.toString(arr));
    }
}