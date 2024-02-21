package easy;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxDepth {

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

    // O(n) time, O(height) space
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
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

        System.out.println(maxDepth(testRoot));
    }
}
