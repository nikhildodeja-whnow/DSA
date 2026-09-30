public class TwoSum {
    public static int[] findPairs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left<right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = findPairs(arr, 25);
        if (result.length > 0) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("No Pairs");
        }

    }
}