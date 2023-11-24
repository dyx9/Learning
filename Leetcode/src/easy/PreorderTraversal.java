package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal {
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

    // O(n) time and space
    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


    // O(n) time and space
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }




    public static void main(String[] args) {
        // test tree
        //       1
        //      / \
        //         2
        //        / \
        //       3
        TreeNode testNode3 = new TreeNode(3);
        TreeNode testNode2 = new TreeNode(2, testNode3, null);
        TreeNode testRoot = new TreeNode(1, null, testNode2);

        System.out.println(preorderTraversalRecursive(testRoot));
        System.out.println(preorderTraversalIterative(testRoot));
    }
}
