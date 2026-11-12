package Tree;

import java.util.List;
import java.util.ArrayList;


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


    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + leftCount + rightCount;
    }
    
    public static TreeNode sortedArrayToBST(
            int[] arr, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = sortedArrayToBST(arr, left, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, right);

        return root;
    }

    public static boolean isBstOrNot(
            TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isBstOrNot(root.left, min, root.val)
                && isBstOrNot(root.right, root.val, max);
    }
    // actually its k smallest in form of inorder travesal
    static int smallestK(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        // Visit left subtree
        int left = smallestK(root.left, k);

        if (left != -1) {
            return left;
        }

        // Visit current node
        count++;

        if (count == k) {
            return root.val;
        }

        // Visit right subtree
        return smallestK(root.right, k);
    }


    static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int height = height(root);
        int width = (1 << height) * 2;

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        for (int depth = 0; depth < height; depth++) {
            int spaces = width / (1 << (depth + 1));

            // Print node values
            for (TreeNode node : level) {
                System.out.printf("%" + spaces + "s",
                        node == null ? "" : node.val);
                System.out.print(" ".repeat(spaces));
            }
            System.out.println();

            // Print branches and prepare next level
            List<TreeNode> next = new ArrayList<>();

            for (TreeNode node : level) {
                if (node == null) {
                    next.add(null);
                    next.add(null);
                } else {
                    next.add(node.left);
                    next.add(node.right);
                }
            }

            for (int i = 0; i < next.size(); i += 2) {
                System.out.print(" ".repeat(Math.max(1, spaces / 2)));
                System.out.print(next.get(i) != null ? "/" : " ");
                System.out.print(" ".repeat(Math.max(1, spaces)));
                System.out.print(next.get(i + 1) != null ? "\\" : " ");
            }
            System.out.println();

            level = next;
        }
    }

    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }


    static void printTreeSideWay(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        // Print right subtree first
        printTreeSideWay(root.right, level + 1);

        // Print spaces before the node
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(root.val);

        // Print left subtree
        printTreeSideWay(root.left, level + 1);
    }


    static void morrisInorder(TreeNode root) {

        TreeNode current = root;

        while (current != null) {

            // Case 1: No left child
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            }

            // Case 2: Left child exists
            else {
                // Find inorder predecessor
                TreeNode predecessor = current.left;

                while (predecessor.right != null &&
                        predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Create temporary thread
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }

                // Thread already exists: remove it
                else {
                    predecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }



    static TreeNode lowestCommonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // Found one of the target nodes
        if (root == p || root == q) {
            return root;
        }

        // Search both subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Targets found on opposite sides
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found a target
        if (left != null) {
            return left;
        }

        return right;
    }


    static TreeNode lcaBST(TreeNode root, int p, int q) {

        if (root == null) {
            return null;
        }

        // Both values are smaller: go left
        if (p < root.val && q < root.val) {
            return lcaBST(root.left, p, q);
        }

        // Both values are larger: go right
        if (p > root.val && q > root.val) {
            return lcaBST(root.right, p, q);
        }

        // Values split, or root equals one target
        return root;
    }



    static int count = 0;
    static int answer = -1;
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

        // build a binary search tree from sorted array // day 22
        int[] sortedArray = {10,20,30,40,50,60,70,80,90};
        TreeNode sortedBST = sortedArrayToBST(sortedArray, 0, sortedArray.length - 1);
        inOrder(sortedBST);
        System.out.println();
        System.out.println("Is Valid Bst = " + isBstOrNot(sortedBST, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(smallestK(sortedBST, 3));
//        printTreeSideWay(sortedBST, 0);
        printTree(sortedBST);
        morrisInorder(sortedBST);
        // lca in binary tree
        TreeNode p = sortedBST.left.left;   //  Node 10
        TreeNode q = sortedBST.left.right;  // Node 30
        TreeNode result = lowestCommonAncestor(sortedBST, p, q);
        System.out.println("p.val =>" + p.val + " q.val =>" + q.val);
        System.out.println("LCA===" + result.val); // 20

        // LCA in BST

        TreeNode result1 = lcaBST(sortedBST, 40, 90);

        if (result1 != null) {
            System.out.println("LCA IN BST==" + result1.val);
        }

    }
}
