class Stack {
    char[] arr;
    int top;

    Stack(int size) {
        arr = new char[size];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == arr.length - 1;
    }

    void push(char value) {
        if (!isFull()) {
            arr[++top] = value;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }

        return arr[top--];
    }

    char peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }

        return arr[top];
    }

    boolean checkValidparentheses(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                this.push(c);
            } else {
                if (this.isEmpty()) {
                    return false;
                }
                char pickChar = this.peek();
                if ((pickChar == '{' && c == '}') || (pickChar == '(' && c == ')') || (pickChar == '[' && c == ']')) {
                    this.pop();
                } else {
                    return false;
                }
            }
        }
        return this.isEmpty();
    }
}

public class LeetCode20Stack {

    public static void main(String[] args) {
        String s = "({[]})";
        Stack stack = new Stack(s.length());
            System.out.println(s + "===> " + stack.checkValidparentheses(s));

        String s1 = "({[]))";
        Stack stack1 = new Stack(s1.length());
        System.out.println(s1 + "===>" + stack1.checkValidparentheses(s));

    }
}