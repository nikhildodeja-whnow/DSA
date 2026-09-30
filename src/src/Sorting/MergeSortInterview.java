import java.util.Arrays;

public class MergeSortInterview {

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return; // Base case

        int mid = low + (high - low) / 2;
        sort(arr, low, mid);       // Sort left half
        sort(arr, mid + 1, high);  // Sort right half
        merge(arr, low, mid, high);// Merge in-place
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid)  temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        // Copy back to original array
        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 1, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 8]
    }
}
