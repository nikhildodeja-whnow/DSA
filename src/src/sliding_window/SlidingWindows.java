// find 3 consecutive numbers sum [1,2,3,4,5,6] = [6,9,12,15]
public class SlidingWindows {

    public static int[] consecutive(int[] nums, int k) {
        final int MAX_LENGTH = 100;
        if (MAX_LENGTH < k) {
            throw new RuntimeException("Length unmatch");
        }
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = k -1 ;
        // Calculate first window
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        int index = 0;
        result[index] = sum;
        index++;

        // Slide the window
        while (right < nums.length - 1) {

            // Remove old element
            sum = sum - nums[left];

            // Move window
            left++;
            right++;

            // Add new element
            sum = sum + nums[right];

            // Store result
            result[index] = sum;
            index++;
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,8,9,14,144,-1};
        int k = 3;

        int[] result = consecutive(nums, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
