package SecondTime.Basic;

public class BasicPointerAndSlidngWindow {

    public static int dumpDuplicateIndexes(int[] numbers) {
        int slow = 0, fast = 1;
        if (numbers.length == 0) {
            return slow;
        }
        while(fast != numbers.length) {
            if(numbers[slow] == numbers[fast]) {
                fast++;
            } else {
                slow++;
                numbers[slow] = numbers[fast];
                fast++;
            }
        }
        return slow + 1;
    }

    public static int[] twoTargetSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while(leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if (sum == target) { return new int[] {leftPointer, rightPointer}; }
            if (sum < target) leftPointer++;
            else rightPointer--;
        }

        return new int[]{-1, -1};
    }

    public static void swapzero(int[] numbers) {
        if (numbers.length == 0) {
            return;
        }
        int slow = 0, fast = 0;
        while(fast < numbers.length) {
            if (numbers[fast] != 0) {
                int temp = numbers[slow];
                numbers[slow] = numbers[fast];
                numbers[fast] = temp;
                slow++;
            }
            fast++;
        }
    }

    // sliding windows

    public static int returnKMaxSum(int[] numbers, int k) {
        if (numbers.length < k) {
            return -1;
        }
        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0; i < k; i++) {
            maxSum += numbers[i];
        }
        windowSum = maxSum;
        for(int i = k; i < numbers.length; i++) {
            windowSum = windowSum - numbers[i-k] + numbers[i];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] duplicateNumbers = {1,1,1,2,2,4,3,3,1,1,4,4,5,5,2,2};
        java.util.Arrays.sort(duplicateNumbers);
        int actualLengthOfUniqueElementInDuplicateNumbers = dumpDuplicateIndexes(duplicateNumbers);
        System.out.println(actualLengthOfUniqueElementInDuplicateNumbers);
        System.out.println("Removed Duplicate Numbers " + java.util.Arrays.toString(java.util.Arrays.copyOf(duplicateNumbers, actualLengthOfUniqueElementInDuplicateNumbers)));

        int[] targetSumArray = {1,3,4,7,8,9,14};
        int target = 22;
        System.out.println("Target Sum for " + target + " indexes returns " + java.util.Arrays.toString(twoTargetSum(targetSumArray, target)));

        // swap 0
        int[] swapZeros = {1,1,1,1,0,2,0,0,9};
        swapzero(swapZeros);
        System.out.println("Swap 0 " + java.util.Arrays.toString(swapZeros));
        int[] maxSumNumbers = {1,3,11,14,15,18,1,3,17};
        System.out.println("MaxSum " + returnKMaxSum(maxSumNumbers, 3));
    }
}

