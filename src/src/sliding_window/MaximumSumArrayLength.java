 /*
  * Problem:
  * Find the maximum length of a consecutive subarray
  * whose sum is less than or equal to the target.
  *
  * Pattern:
  * Variable-Size Sliding Window
  *
  * Example:
  * nums = [2, 1, 1, 1, 3]
  * target = 5
  *
  * Expected Output:
  * 4
  *
  * Explanation:
  * [2, 1, 1, 1] = 5
  * Length = 4
  *
  * Logic:
  * - left and right start at 0.
  * - Move right to expand the window.
  * - Add nums[right] to sum.
  * - If sum becomes greater than target,
  *   shrink the window from the left.
  * - Once the window becomes valid,
  *   calculate its length.
  * - Keep the maximum length found.
  */

 public class MaximumSumArrayLength {

     public static int findMaximumSumFromArray(int[] nums, int target) {

         int left = 0;
         int right = 0;

         int sum = 0;
         int maxLength = 0;

         while (right < nums.length) {

             // Add the right element to the current window
             sum += nums[right];

             /*
              * If sum is greater than target,
              * the window is invalid.
              *
              * Keep removing elements from the left
              * until the window becomes valid.
              */
             while (sum > target) {
                 sum -= nums[left];
                 left++;
             }

             // Current window is now valid
             int currentLength = right - left + 1;

             // Keep the maximum window length
             if (currentLength > maxLength) {
                 maxLength = currentLength;
             }

             // Expand the window
             right++;
         }

         return maxLength;
     }

     public static void main(String[] args) {

         int[] nums = {2, 1, 1, 1, 3};
         int target = 5;

         int result = findMaximumSumFromArray(nums, target);

         System.out.println("Maximum window length = " + result);
     }
 }