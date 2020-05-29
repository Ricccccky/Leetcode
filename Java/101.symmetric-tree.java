import java.util.Stack;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        Stack<TreeNode> temp = new Stack<>();
        temp.push(root.left);
        temp.push(root.right);
        
        while (!temp.isEmpty()) {
            rightNode = temp.pop();
            leftNode = temp.pop();

            if (leftNode == null && rightNode == null) {
                continue;
            } else if ((leftNode == null || rightNode == null) || leftNode.val != rightNode.val){
                return false;
            }
            temp.push(leftNode.left);
            temp.push(rightNode.right);
            temp.push(leftNode.right);
            temp.push(rightNode.left);
        }
        return true;
    }
}
// @lc code=end

