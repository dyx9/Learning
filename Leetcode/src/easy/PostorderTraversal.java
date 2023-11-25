package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraversal {
    
    // Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // O(n)
    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // O(n)
    public static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        // save node for right child check
        TreeNode prev=null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // pop last node if no left child
            root = stack.pop();
            // check if there's a right child, 
            // or check if the right child has been visited
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                // save current node for right child check
                prev = root;
                // go to last node in the stack if any
                root = null;
            }
            else {
                // put the node back to the stack if there's right child
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // test tree
        //       1
        //      / \
        //     2   3

        TreeNode testNode2 = new TreeNode(2);
        TreeNode testNode3 = new TreeNode(3);
        TreeNode testRoot = new TreeNode(1, testNode2, testNode3);

        System.out.println(postorderTraversalIterative(testRoot));
    }
}
