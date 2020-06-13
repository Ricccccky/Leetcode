import java.util.HashSet;
import java.util.Stack;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> result = new HashSet<>();
        Stack<TreeNode> temp = new Stack<>();
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                if (result.contains(k - root.val)) {
                    return true;
                }
                result.add(root.val);
                temp.push(root);
                root = root.left;
            } else {
                root = temp.pop().right;
            }
        }
        return false;
    }
}
// @lc code=end

