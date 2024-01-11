import java.util.*;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        // // DFS
        // if (root == null) {
        //     return res;
        // }
        // dfs(root, 0);

        // return res;

        // BFS
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        int len;
        temp.offer(root);
        while (!temp.isEmpty()) {
            len = temp.size();
            for (int i = 0; i < len; i++) {
                root = temp.poll();
                if (root.left != null) {
                    temp.offer(root.left);
                }
                if (root.right != null) {
                    temp.offer(root.right);
                }
            }
            result.add(root.val);
        }

        return result;
    }

    private List<Integer> res = new ArrayList<>();

    private void dfs(TreeNode root, int level) {
        if (level == res.size()) {
            res.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
        }
        if (root.left != null) {
            dfs(root.left, level + 1);
        }
    }
}
// @lc code=end

