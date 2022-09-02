import java.util.*;

/*
 * @lc app=leetcode id=545 lang=java
 *
 * [545] Boundary of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        res.add(root.val);
        if (isLeaf(root)) {
            return res;
        }
        // Add left boundary
        TreeNode ptr = root.left;
        while (ptr != null) {
            if (!isLeaf(ptr)) {
                res.add(ptr.val);
            }
            if (ptr.left != null) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        // Add leaves
        addLeaves(res, root);
        ptr = root.right;
        // Add right boundary
        while (ptr != null) {
            if (!isLeaf(ptr)) {
                stack.addFirst(ptr.val);
            }
            if (ptr.right != null) {
                ptr = ptr.right;
            } else {
                ptr = ptr.left;
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.removeFirst());
        }

        return res;
    }

    private void addLeaves(List<Integer> res, TreeNode node) {
        if (isLeaf(node)) {
            res.add(node.val);
        } else {
            if (node.left != null) {
                addLeaves(res, node.left);
            }
            if (node.right != null) {
                addLeaves(res, node.right);
            }
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
// @lc code=end

