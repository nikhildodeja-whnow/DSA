package Queue;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueL {
    Node front;
    Node rear;

    boolean isEmpty() {
        if (rear == null) {
            return true;
        }
        return false;
    }

    void enqueue(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if (isEmpty())  {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return val;
    }

    int peek () {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
}

public class QueueWithList {
    public static void main(String[] args) {
        QueueL queue = new QueueL();

        System.out.println("Is empty: " + queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());

        System.out.println("Removed: " + queue.dequeue());

        System.out.println("Front: " + queue.peek());

        System.out.println("Removed: " + queue.dequeue());

        System.out.println("Removed: " + queue.dequeue());

        System.out.println("Is empty: " + queue.isEmpty());
    }
}
