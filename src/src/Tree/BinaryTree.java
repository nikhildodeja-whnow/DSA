package Tree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

class Node {
    Node left;
    int data;
    Node right;

    Node(int data) {
        this.left = null;
        this.data = data;
        this.right = null;
    }
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}

public class BinaryTree {
    // Root -> Left -> Right
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Left -> Root -> Right
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }

    // Left -> Right -> Root
    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + ", ");
    }

    // Level Order
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + ", ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void printOrderLevel(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                System.out.print(current.data + ", ");
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            System.out.println();
        }
    }

    public static void printLevelOrderTravesalUsingDqueue(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        Node last = root;

        while (!q.isEmpty()) {
            Node x = q.poll();
            System.out.print(x.data + " ");

            if (x.left != null) {
                q.offer(x.left);
            }
            if (x.right != null) {
                q.offer(x.right);
            }

            if (x == last && !q.isEmpty()) {
                System.out.println();
                last = q.peekLast();
            }
        }
        System.out.println();
    }

    // BFS - Right View
    public static void getRightView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();

                if (i == levelSize - 1) {
                    System.out.print(curr.data + ", ");
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
    }

    // BFS - Left View
    public static void getLeftView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();

                if (i == 0) {
                    System.out.print(curr.data + ", ");
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
    }

    // ==========================================
    // DFS IMPLEMENTATIONS (Left View & Right View)
    // ==========================================

    // DFS - Left View Entry Point
    public static void getLeftViewDFS(Node root) {
        List<Integer> result = new ArrayList<>();
        dfsLeft(root, 0, result);
        for (int val : result) {
            System.out.print(val + ", ");
        }
    }

    // Helper: visits LEFT first so it claims the level in 'result'
    private static void dfsLeft(Node curr, int level, List<Integer> result) {
        if (curr == null) return;

        // If this is the first node reached at this depth level
        if (level == result.size()) {
            result.add(curr.data);
        }

        dfsLeft(curr.left, level + 1, result);
        dfsLeft(curr.right, level + 1, result);
    }

    // DFS - Right View Entry Point
    public static void getRightViewDFS(Node root) {
        List<Integer> result = new ArrayList<>();
        dfsRight(root, 0, result);
        for (int val : result) {
            System.out.print(val + ", ");
        }
    }

    // Helper: visits RIGHT first so it claims the level in 'result'
    private static void dfsRight(Node curr, int level, List<Integer> result) {
        if (curr == null) return;

        // If this is the first node reached at this depth level
        if (level == result.size()) {
            result.add(curr.data);
        }

        dfsRight(curr.right, level + 1, result);
        dfsRight(curr.left, level + 1, result);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node rootLeft = new Node(5);
        Node rootRight = new Node(20);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = new Node(4);
        rootLeft.right = new Node(7);
        rootRight.left = new Node(17);
        rootRight.right = new Node(25);

        preOrder(root);
        System.out.println("Pre Order Traversal");

        inOrder(root);
        System.out.println("In Order Traversal");

        postOrder(root);
        System.out.println("Post Order Traversal");

        levelOrder(root);
        System.out.println("Level Order Traversal");

        System.out.println("Print order level");
        printOrderLevel(root);

        System.out.println("Print order level using deque");
        printLevelOrderTravesalUsingDqueue(root);

        System.out.println("Print Left View (BFS):");
        getLeftView(root);
        System.out.println();

        System.out.println("Print Right View (BFS):");
        getRightView(root);
        System.out.println();

        System.out.println("Print Left View (DFS):");
        getLeftViewDFS(root);
        System.out.println();

        System.out.println("Print Right View (DFS):");
        getRightViewDFS(root);
        System.out.println();
    }
}