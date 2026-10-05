package Backtracing;
import java.util.ArrayList;
import java.util.List;

public class Permutation {

    static void generate(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            System.out.println(path);
            return;
        }
        for(int index = 0; index < nums.length; index++ ) {
            if (used[index]) {
                continue;
            }
            path.add(nums[index]);
            used[index] = true;
            generate(nums, used, path);

            path.remove(path.size() - 1);
            used[index] = false;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        List<Integer> path = new ArrayList<>();
        boolean[] used = {false, false};
        generate(nums, used, path);
    }
}
