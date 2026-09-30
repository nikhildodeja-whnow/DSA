/*
 * Problem:
 * Find the minimum length of a consecutive subarray
 * whose sum is greater than or equal to the target.
 *
 * Pattern:
 * Variable-Size Sliding Window
 *
 * Example:
 * nums = [2, 3, 1, 2, 4, 3]
 * target = 7
 *
 * Expected Output:
 * 2
 *
 * Logic:
 * - left and right start at 0.
 * - Move right to expand the window.
 * - When sum >= target, record the window length.
 * - Move left to shrink the window.
 * - Keep the minimum length found.
 */

public class MinimumSumArrayLength {

    public static int findMinimumSumFromArray(int[] nums, int target) {

        int left = 0;
        int right = 0;

        int sum = 0;
        int answer = Integer.MAX_VALUE;

        while (right < nums.length) {

            // Expand the window
            sum += nums[right];

            // Shrink the window while sum is >= target
            while (sum >= target) {

                // Calculate current window length
                int currentLength = right - left + 1;

                // Keep the minimum length
                if (currentLength < answer) {
                    answer = currentLength;
                }

                // Remove left element
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = findMinimumSumFromArray(nums, target);

        System.out.println(result);
    }
}