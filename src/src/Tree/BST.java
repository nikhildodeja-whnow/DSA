package Tree;


class TreeNode {
    TreeNode left;
    int val;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BST {

    public static TreeNode insert(TreeNode root, int val){
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right,val);
        }
        return root;
    }

    // Left -> Root -> Right
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + ", ");
        inOrder(root.right);
    }

    public static TreeNode searchRecurrsively(TreeNode root, int target) {
        // Base cases: root is null (not found) OR root is the target (found!)
        if (root == null || root.val == target) {
            return root;
        }

        // Target is smaller -> search left subtree
        if (target < root.val) {
            return searchRecurrsively(root.left, target);
        }

        // Target is greater -> search right subtree
        return searchRecurrsively(root.right, target);
    }

    public static TreeNode search(TreeNode root, int target) {
        TreeNode current = root;

        while (current != null) {
            if (current.val == target) {
                return current; // Found!
            } else if (target < current.val) {
                current = current.left;  // Move left
            } else {
                current = current.right; // Move right
            }
        }

        return null; // Hit null -> target not in tree
    }
    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 50);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 47);
        root = insert(root, 37);
        root = insert(root,55);
        inOrder(root);

        TreeNode found = search(root, 47);
        System.out.println("\nSearch 47: " + (found != null ? "Found (" + found.val + ")" : "Not Found"));

        TreeNode notFound = search(root, 99);
        System.out.println("Search 99: " + (notFound != null ? "Found (" + notFound.val + ")" : "Not Found"));

        System.out.println("Search Backtracing or REcurrsively");
        TreeNode foundR = searchRecurrsively(root, 47);
        System.out.println("\nSearch 47: " + (found != null ? "Found (" + found.val + ")" : "Not Found"));

        TreeNode notFoundR = searchRecurrsively(root, 99);
        System.out.println("Search 99: " + (notFound != null ? "Found (" + notFound.val + ")" : "Not Found"));
    }
}
