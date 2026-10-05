package Backtracing;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum {

    static void generate(int[] nums, int index, List<Integer> path, int remain, int target) {
        if (remain == 0) {
            System.out.println(path);
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > remain) {
                continue;
            }
            path.add(nums[i]);
            generate(nums, i, path, remain - nums[i], target);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        List<Integer> path = new ArrayList<>();
        int k = 7;
        generate(nums, 0, path, k, k);
    }
}
