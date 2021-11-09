import java.util.*;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<StringBuilder> paths = new LinkedList<>();
        queue.offer(root);
        paths.offer(new StringBuilder("" + root.val));
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                StringBuilder path = paths.poll();
                if (node.left == null && node.right == null) {
                    res.add(path.toString());
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    paths.offer(new StringBuilder(path).append("->").append(node.left.val));
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    paths.offer(new StringBuilder(path).append("->").append(node.right.val));
                }
            }
        }
        
        return res;
    }
}
// @lc code=end

