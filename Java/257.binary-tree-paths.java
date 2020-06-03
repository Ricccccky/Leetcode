import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();
        String path;
        nodes.offer(root);
        paths.offer("" + root.val);
        while (!nodes.isEmpty()) {
            root = nodes.poll();
            path = paths.poll();
            if (root.left == null && root.right == null) {
                result.add(path);
            }
            if (root.left != null) {
                nodes.offer(root.left);
                paths.offer(path + "->" + root.left.val);
            }
            if (root.right != null) {
                nodes.offer(root.right);
                paths.offer(path + "->" + root.right.val);
            }
        }
        return result;
    }
}
// @lc code=end

