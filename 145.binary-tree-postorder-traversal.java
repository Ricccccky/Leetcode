import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> temp = new Stack<>();
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                temp.push(root);
                result.add(root.val);
                root = root.right;
            } else {
                root = temp.pop().left;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
// @lc code=end

