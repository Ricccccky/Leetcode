/*
 * @lc app=leetcode id=1145 lang=java
 *
 * [1145] Binary Tree Coloring Game
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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] player1 = new int[] {x, 0, 0};
        dfs(root, player1);
        int maxSubtree = Math.max(Math.max(player1[1], player1[2]), n - player1[1] - player1[2] - 1);
        if (maxSubtree > n / 2) {
            return true;
        } else {
            return false;
        }
    }

    private int dfs(TreeNode root, int[] player1) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, player1);
        int right = dfs(root.right, player1);
        if (root.val == player1[0]) {
            player1[1] = left;
            player1[2] = right;
        }
        return left + right + 1;
    }
}
// @lc code=end

