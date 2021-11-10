import java.util.*;

/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode result = root;
        Stack<TreeNode> temp = new Stack<>();
        int greaterSum = 0;
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                temp.push(root);
                root = root.right;
            } else {
                root = temp.pop();
                root.val += greaterSum;
                greaterSum = root.val;
                root = root.left;
            }
        }
        return result;
    }
}
// @lc code=end

