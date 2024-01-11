import java.util.*;

/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
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
    private int result;
    public int minCameraCover(TreeNode root) {
        result = 0;
        Set<TreeNode> set =  new HashSet<>();
        set.add(null);
        dfs(root, null, set);

        return result;
    }

    private void dfs(TreeNode root, TreeNode par, Set<TreeNode> set) {
        if (root != null) {
            dfs(root.left, root, set);
            dfs(root.right, root, set);
            // First condition is for root only
            if (par == null && !set.contains(root) || !set.contains(root.left) || !set.contains(root.right)) {
                result++;
                set.add(root);
                set.add(par);
                set.add(root.left);
                set.add(root.right);
            }
        }
    }
}
// @lc code=end

