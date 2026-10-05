package Backtracing;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_II {
    static void generate(int[] nums, int index, List<Integer> path, int remain) {
        if (remain == 0) {
            System.out.println(path);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > remain) {
                continue;
            }
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);

            generate(nums, i+1, path, remain - nums[i]);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,5,6,7};
        List<Integer> path = new ArrayList<>();
        int k = 9;
        generate(nums, 0, path, k);
    }
}
