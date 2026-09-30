public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }
    public static void main(String[] args) {
        int[] nums  = {1,1,2,2,2,3,3,4};
        int newLength = removeDuplicates(nums);

        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}