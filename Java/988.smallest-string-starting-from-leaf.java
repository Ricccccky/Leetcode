import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        PriorityQueue<String> result = new PriorityQueue<>();
        dfs(root, result, "");
        return result.poll();
    }

    private void dfs (TreeNode root, PriorityQueue<String> result, String temp) {
        char rootChar = (char)('a' + root.val);
        temp = rootChar + temp;
        if (root.left == null && root.right == null) {
            result.add(temp);
            return;
        }
        if (root.left != null) {
            dfs(root.left, result, temp);
        }
        if (root.right != null) {
            dfs(root.right, result, temp);
        }
    }
}
// @lc code=end

