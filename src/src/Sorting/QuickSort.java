package Sorting;

/*
 * Quick Sort
 *
 * Approach:
 * 1. Choose the last element as pivot.
 * 2. Partition the array around the pivot.
 * 3. Elements <= pivot go to the left.
 * 4. Elements > pivot stay on the right.
 * 5. Put the pivot in its correct position.
 * 6. Recursively apply Quick Sort to the left and right parts.
 *
 * Example:
 *
 * [5, 3, 8, 1, 2]
 *
 * pivot = 2
 *
 * After partition:
 * [1, 2, 8, 5, 3]
 *     ↑
 *   pivot
 *
 * Then sort:
 * [1]
 * [8, 5, 3]
 *
 * Time Complexity:
 * Best Case    -> O(n log n)
 * Average Case -> O(n log n)
 * Worst Case   -> O(n²)
 *
 * Space Complexity:
 * Average      -> O(log n) recursion stack
 * Worst        -> O(n) recursion stack
 */

public class QuickSort {

    public static void sort(int[] arr, int low, int high) {

        // Base condition
        if (low < high) {

            // Partition the array
            int pivotIndex = partition(arr, low, high);

            // Sort left side of pivot
            sort(arr, low, pivotIndex - 1);

            // Sort right side of pivot
            sort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        // Last element is our pivot
        int pivot = arr[high];

        // i represents the position
        // where the next smaller element should go
        int i = low - 1;

        // j scans the array
        for (int j = low; j < high; j++) {

            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {

                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Put pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return pivot's final position
        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 2};

        System.out.println("Before sorting:");
        System.out.println(java.util.Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        System.out.println("After sorting:");
        System.out.println(java.util.Arrays.toString(arr));
    }
}