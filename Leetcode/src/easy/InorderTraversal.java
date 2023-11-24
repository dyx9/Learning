package easy;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

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

    // O(n) both time and space
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // O(n) both time and space
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // O(n) time and O(1) space
    public List<Integer> inorderTraversalMorris(TreeNode root) {

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

        System.out.println(inorderTraversalIterative(testRoot));
    }
}
