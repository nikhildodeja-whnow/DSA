package Stack;

class Node {
    int data;
    Node next;

    Node(int data) {
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

    void push(int val) {
        if (isEmpty()) {
            top = new Node(val);
            return;
        }
        Node node = new Node(val);
        node.next = top;
        top = node;

    }

    int pop() {
       if (isEmpty()) {
           System.out.println("Stack undeflow");
           return 0;
       }
       int value = top.data;
       top = top.next;
       return value;
    }

    int peek () {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return 0;
        }
        return top.data;
    }
}

public class StackUsingLinkList {

    public static void main(String[] args) {
        Linklist list = new Linklist();

        list.push(10);
        list.push(20);
        list.push(30);

        System.out.println(list.peek()); // 30

        System.out.println(list.pop());  // 30
        System.out.println(list.pop());  // 20
        System.out.println(list.pop());  // 10

        System.out.println(list.isEmpty()); // true

    }
}