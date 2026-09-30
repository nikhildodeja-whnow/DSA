package sliding_window;

public class SlidingWindowsMax {

    public static int consecutive(int[] nums, int k) {

        if (k <= 0 || nums.length < k) {
            throw new RuntimeException("Invalid window size");
        }

        int left = 0;
        int right = k - 1;

        // Calculate first window
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        while (right < nums.length - 1) {

            // Remove old element
            sum = sum - nums[left];

            // Move window
            left++;
            right++;

            // Add new element
            sum = sum + nums[right];

            // Update maximum
            if (sum > maxSum) {
                maxSum = sum;
            }

            // Update minimum
            // if (sum < maxSum) {
                // maxSum = sum;
            // }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, -6, 25};
        int k = 3;

        int result = consecutive(nums, k);

        System.out.println(result);
    }
}