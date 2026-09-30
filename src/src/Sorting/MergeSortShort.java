import java.util.Arrays;

public class MergeSortShort {

    public static void sort(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        // Replaces all the manual for-loops in 2 lines:
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 8]
    }
}
