public class TwoSumPair {
    public static int[][] findPairs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int[][] result = new int[arr.length / 2][2];
        int index = 0;
        while(left<right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[index][0] = arr[left];
                result[index][1] = arr[right];

                index++;
                left++;
                right--;
                continue;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] result = findPairs(arr, 10);
        if (result.length > 0) {
            for(int i =0; i < result.length-1;i++ ) {
                System.out.println(result[i][0] + " " + result[i][1]);
            }
        } else {
            System.out.println("No Pairs");
        }
//        if (result.length > 0) {
//            System.out.println(result[0] + " " + result[1]);
//        } else {
//            System.out.println("No Pairs");
//        }

    }
}