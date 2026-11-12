package LeetCodeQuestions;
import java.util.Stack;
import java.util.Arrays;

// Question : 735 Leet
public class AstroidCollasion {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean shouldAddinStack = true;

            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (stack.peek() < Math.abs(ast)) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == Math.abs(ast)) {
                    stack.pop();
                    shouldAddinStack = false;
                } else {
                    shouldAddinStack = false;
                }
                break;
            }

            if (shouldAddinStack) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        AstroidCollasion solver = new AstroidCollasion();

        int[][] testCases = {
                {5, 10, -5},
                {8, -8},
                {10, 2, -5},
                {-2, -1, 1, 2},
                {5,10,-9,20,-11,-21,22}
        };

        for (int[] t : testCases) {
            System.out.println("Input: " + Arrays.toString(t) +
                    " -> Result: " + Arrays.toString(solver.asteroidCollision(t)));
        }
    }
}