package Backtracing;

import java.util.List;
import java.util.ArrayList;

public class Subset_II {

    static void generate(int[] nums, int index, List<Integer> path) {
            System.out.println(path);

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);

            generate(nums, i + 1, path);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> path = new ArrayList<>();
        int[] nums = {1, 2, 2,3,3,4,4,4,5,5,5};
        generate(nums, 0, path);
    }
}
