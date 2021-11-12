import java.util.*;

/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> temp = new HashMap<>();
        int result = 0;
        findDepth(root, temp);
        for (Map.Entry<TreeNode, Integer> k : temp.entrySet()) {
            result = Math.max(result, k.getValue());
        }

        return result;
    }

    private int findDepth(TreeNode root, Map<TreeNode, Integer> data) {
        if (root == null) {
            return 0;
        }
        int left = findDepth(root.left, data);
        int right = findDepth(root.right, data);
        data.put(root, left + right);

        return Math.max(left, right) + 1;
    }
}
// @lc code=end

