package Backtracing;
import java.util.ArrayList;
import java.util.List;

public class Combination {

    static void generate(int[] nums, int index, List<Integer> path, int k) {

        if (path.size() == k) {
            System.out.println(path);
            return;
        }

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            generate(nums, i + 1, path, k);

            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<Integer> path = new ArrayList<>();
        int k = 2;
        generate(nums, 0, path, k);
    }
}
