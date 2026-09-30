package Queue;

class Queue {
    int[] arr;
    int front, rear;

    Queue(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
    }
    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        return rear == arr.length - 1;
    }

    void enqueue(int val) {
        if (isFull()) {
            return;
        }
        arr[++rear] = val;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = arr[front];
        if (front == rear) {
            front = 0;
            rear = -1;
        } else {
            front++;
        }
        return val;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println(("Queue is empty"));
            return -1;
        }
        return arr[front];
    }
}

public class QueueWithArray {
    public static void main(String[] args) {
        Queue que = new Queue(5);

        que.enqueue(10);
        que.enqueue(20);
        que.enqueue(30);
        System.out.println(que.peek());     // 10
        System.out.println(que.dequeue());  // 10
        System.out.println(que.peek());     // 20
        System.out.println(que.dequeue());  // 20
        System.out.println(que.dequeue());  // 30
        System.out.println(que.isEmpty());  // true
    }
}
