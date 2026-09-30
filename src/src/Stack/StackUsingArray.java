package Stack;



class Stack {
    int[] arr;
    int top;

    Stack(int size) {
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
            System.out.println("Stack Undeflow");
            return 0;
        }
        return arr[top];
    }
}



public class StackUsingArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(java.util.Arrays.toString(stack.arr));
        System.out.println(stack.peek()); // 50

        System.out.println(stack.pop());  // 50
        System.out.println(stack.pop());  // 40

        System.out.println(stack.peek()); // 30

        System.out.println(stack.isEmpty()); // false

    }
}