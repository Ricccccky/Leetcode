import java.util.*;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    // Recursive solution
    // List<Integer> temp = new ArrayList<>();
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if (root == null) {
    //         return temp;
    //     }
    //     inorder(root);
    //     return temp;
    // }

    // public void inorder(TreeNode root) {
    //     if (root != null) {
    //         inorder(root.left);
    //         temp.add(root.val);
    //         inorder(root.right);
    //     }
    // }

    // Iterative solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.addFirst(root);
                root = root.left;
            } else {
                root = stack.removeFirst();
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
    }
}
// @lc code=end

