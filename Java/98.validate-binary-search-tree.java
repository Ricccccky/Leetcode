import java.util.*;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    // public boolean isValidBST(TreeNode root) {
    //     Deque<TreeNode> stack = new LinkedList<>();
    //     TreeNode prev = null;
    //     while (!stack.isEmpty() || root != null) {
    //         if (root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         } else {
    //             root = stack.pop();
    //             if (prev != null && prev.val >= root.val) {
    //                 return false;
    //             }
    //             prev = root;
    //             root = root.right;
    //         }
    //     }
        
    //     return true;
    // }

    // Morris Traversal (Using Threaded Tree for Inorder Traversal), O(n) time and O(1) space
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.left != null) {
                TreeNode predecessor = curNode.left;
                // find the last node in the traversal path of current subtree
                while (predecessor.right != null && predecessor.right != curNode) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    // first time visit this most right node, link it to curNode
                    predecessor.right = curNode;
                    curNode = curNode.left;
                } else {
                    // first time visit this most right node, remove the link created above and go back to that predecessor
                    predecessor.right = null;
                    if (prev != null && prev.val >= curNode.val) {
                        return false;
                    }
                    prev = curNode;
                    curNode = curNode.right;
                }
            } else {
                if (prev != null && prev.val >= curNode.val) {
                    return false;
                }
                prev = curNode;
                curNode = curNode.right;
            }
        }
        
        return true;
    }
}
// @lc code=end

