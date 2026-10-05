package Backtracing;

public class PermutationWithSwap {

    static void generate(int[] nums, int index) {

        // Base case
        if (index == nums.length) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // Try every element at current position
        for (int i = index; i < nums.length; i++) {

            // CHOOSE
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            // EXPLORE
            generate(nums, index + 1);

            // UNDO / BACKTRACK
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        generate(nums, 0);
    }
}