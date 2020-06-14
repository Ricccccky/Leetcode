import java.util.LinkedList;
import java.util.Queue;

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
        int result = 1;
        int len = 0;
        int curIndex, leftIndex, rightIndex;
        Queue<TreeNode> temp = new LinkedList<>();
        Queue<Integer> nodeIndex = new LinkedList<>();
        temp.offer(root);
        nodeIndex.offer(1);
        while (!temp.isEmpty()) {
            len = temp.size();
            leftIndex = Integer.MAX_VALUE;
            rightIndex = 0;
            for (int i = 0; i < len; i++) {
                root = temp.poll();
                curIndex = nodeIndex.poll();
                if (root.left != null) {
                    temp.offer(root.left);
                    nodeIndex.offer(curIndex * 2);
                    leftIndex = Math.min(curIndex * 2, leftIndex);
                    rightIndex = Math.max(curIndex * 2, rightIndex);
                }
                if (root.right != null) {
                    temp.offer(root.right);
                    nodeIndex.offer(curIndex * 2 + 1);
                    leftIndex = Math.min(curIndex * 2 + 1, leftIndex);
                    rightIndex = Math.max(curIndex * 2 + 1, rightIndex);
                }
            }
            if (leftIndex != Integer.MAX_VALUE && rightIndex != 0) {
                result = Math.max(result, rightIndex - leftIndex + 1);
            }
        }
        return result;
    }
}
// @lc code=end

