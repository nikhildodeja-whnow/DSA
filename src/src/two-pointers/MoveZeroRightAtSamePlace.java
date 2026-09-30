public class MoveZeroRightAtSamePlace {

    public static void moveZeros(int[] arr) {

        int left = 0;
        int right = 0;

        while (right < arr.length) {

            if (arr[right] != 0) {

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
            }

            right++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};

        moveZeros(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}