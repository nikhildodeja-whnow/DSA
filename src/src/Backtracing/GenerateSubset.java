package Backtracing;

import java.util.List;
import java.util.ArrayList;

public class GenerateSubset {

    static void generate(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            System.out.println(path);
            return;
        }
        path.add(nums[index]);
        generate(nums, index + 1, path);
        path.remove(path.size() - 1);

        generate(nums, index + 1, path);
    }

    public static void main(String[] args) {
        List<Integer> path = new ArrayList<>();
        int[] nums = {1, 2, 3};
        generate(nums, 0, path);
    }
}
