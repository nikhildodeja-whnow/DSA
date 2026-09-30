
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Linklist {
    Node top;

    Linklist() {
        top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(char val) {
        Node node = new Node(val);
        node.next = top;
        top = node;
    }

    char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }

        char value = top.data;
        top = top.next;

        return value;
    }

    char peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }

        return top.data;
    }
}

public class ReverseStringUsingStack {

    public static void main(String[] args) {

        String str = "hello";

        Linklist stack = new Linklist();

        // Push every character into Stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Pop every character to reverse the string
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}