public class SortZeroAndOne {

    public static void sort(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] == 0 && arr[right] == 1) {

                left++;
                right--;

            } else if (arr[left] == 1 && arr[right] == 0) {

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;

            } else if (arr[left] == 1 && arr[right] == 1) {

                left++;

            } else {

                right--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 0, 1, 0, 0, 1};

        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}