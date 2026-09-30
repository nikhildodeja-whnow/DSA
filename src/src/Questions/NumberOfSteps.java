package Questions;

/*
 * LeetCode 1342 - Number of Steps to Reduce a Number to Zero
 *
 * Problem:
 * Given an integer num, reduce it to zero.
 *
 * Rules:
 * 1. If num is even, divide it by 2.
 * 2. If num is odd, subtract 1.
 * 3. Count the number of steps.
 *
 * Example:
 *
 * num = 14
 *
 * 14 -> 7   (divide by 2)
 * 7  -> 6   (subtract 1)
 * 6  -> 3   (divide by 2)
 * 3  -> 2   (subtract 1)
 * 2  -> 1   (divide by 2)
 * 1  -> 0   (subtract 1)
 *
 * Answer = 6
 *
 * Time Complexity:
 * O(log n)
 *
 * Space Complexity:
 * O(1)
 */

public class NumberOfSteps {

    public static int numberOfSteps(int num) {

        int steps = 0;

        while (num != 0) {

            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {

        int num = 2522;

        int answer = numberOfSteps(num);

        System.out.println("Number of steps = " + answer);
    }
}