import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return root;
        }
        if (d == 1) {
            TreeNode t = new TreeNode(v);
            t.left = root;
            return t;
        }
        TreeNode head = root;
        Queue<TreeNode> temp = new LinkedList<>();
        int count = 1;
        int len;
        temp.offer(head);
        while (!temp.isEmpty()) {
            count++;
            len = temp.size();
            if (count == d) {
                for (int i = 0; i < len; i++) {
                    head = temp.poll();
                    TreeNode t = head.left;
                    head.left = new TreeNode(v);
                    head.left.left = t;
                    t = head.right;
                    head.right = new TreeNode(v);
                    head.right.right = t;
                }
                break;
            }
            for (int i = 0; i < len; i++) {
                head = temp.poll();
                if (head.left != null) {
                    temp.offer(head.left);
                }
                if (head.right != null) {
                    temp.offer(head.right);
                }
            }
        }
        return root;
    }
}
// @lc code=end

