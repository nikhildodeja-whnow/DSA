class Stack1 {
    int[] arr;
    int top;

    Stack1(int size) {
        arr = new int[size];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == arr.length - 1;
    }

    void push(int value) {
        if (!isFull()) {
            arr[++top] = value;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        }

        return arr[top--];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        }

        return arr[top];
    }
}

public class HistogramUsingStack {

    public static void main(String[] args) {

        int[] heights = {1, 7, 7, 8, 3, 2};

        int maxArea = 0;

        Stack1 stack = new Stack1(heights.length);

        // i == heights.length means imaginary height 0
        for (int i = 0; i <= heights.length; i++) {

            int current = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > current) {

                int poppedIndex = stack.pop();

                int height = heights[poppedIndex];

                int left = stack.isEmpty() ? -1 : stack.peek();

                int right = i;

                int width = right - left - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        System.out.println("Maximum Area = " + maxArea);
    }
}