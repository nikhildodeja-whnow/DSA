package Backtracing;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class BackTraceWithList {

    static void generate(List<Integer> path) {
        if (path.size() == 3) {
            System.out.println(path);
            return;
        }
        // Choice 0
        path.add(0);
        generate(path);
        path.remove(path.size() - 1);

        // Choice 1
        path.add(1);
        generate(path);
        path.remove(path.size() - 1);
    }
    static void generate12(List<Integer> path) {
        if (path.toArray().length == 2) {
            System.out.println(path);
            return;
        }
        path.add(1);
        generate12(path);
        path.remove(path.size() - 1);

        path.add(2);
        generate12(path);
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        List<Integer> path = new ArrayList<>();
        generate(path);
        List<Integer> path1 = new ArrayList<>();
        generate12(path1);
    }
}
