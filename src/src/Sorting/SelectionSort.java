

public class SelectionSort {

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int currentPosition = i;
            int swapPosition = i;
            for (int j = i; j < arr.length - 1; j++) {

                if (arr[swapPosition] > arr[j+1]) {
                    swapPosition = j + 1;
                }
            }
            if (currentPosition != swapPosition) {
                int temp = arr[currentPosition];
                arr[currentPosition] = arr[swapPosition];
                arr[swapPosition] = temp;
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