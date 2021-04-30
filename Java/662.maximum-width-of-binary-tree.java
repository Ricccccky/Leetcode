import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.offer(root);
        index.offer(1);
        while (!queue.isEmpty()) {
            int len =queue.size();
            int head = index.peek();
            int tail = 0;
            while (len-- > 0) {
                root = queue.poll();
                tail = index.poll();
                if (root.left != null) {
                    queue.offer(root.left);
                    index.offer(tail * 2);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                    index.offer(tail * 2 + 1);
                }
            }
            res = Math.max(res, tail - head + 1);
        }

        return res;
    }
}
// @lc code=end

