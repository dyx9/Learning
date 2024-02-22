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
    // Depth First Search
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    // O(n) time and space
    // Bepth First Search
    public int maxDepthIterative(TreeNode root) {
        if (root == null) return 0;

        // Initialize a queue to hold the tree nodes for level-order traversal.
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to the queue as the starting point of the traversal.
        queue.offer(root);

        int depth = 0;

        // Continue the loop until the queue is empty, indicating that all levels have been visited.
        while (!queue.isEmpty()) {
            // Determine the number of nodes at the current level.
            int levelSize = queue.size();

            // Process all nodes of the current level.
            for (int i = 0; i < levelSize; i++) {
                // Remove the front node from the queue to process it.
                TreeNode current = queue.poll();

                // If the current node has a left child, add it to the queue for later processing.
                if (current.left != null) queue.offer(current.left);
                // If the current node has a right child, add it to the queue too.
                if (current.right != null) queue.offer(current.right);
            }

            // After processing all nodes at the current level, increase the depth counter.
            depth++;
        }

        // Once the queue is empty, all levels have been processed, and 'depth' holds the maximum depth of the tree.
        return depth;
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
