import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

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
        Stack<TreeNode> temp = new Stack<>();
        if (root == null) {
            return result;
        }

        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                temp.push(root);
                root = root.left;
            } else {
                root = temp.pop();
                System.out.println(root.val);
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
// @lc code=end

