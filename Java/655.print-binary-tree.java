import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=655 lang=java
 *
 * [655] Print Binary Tree
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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int depth = findDepth(root);
        int rowLength = (int)Math.pow(2, depth) - 1;
        int len;
        int level = 0;
        int mid;
        int[] curIndex;
        List<String> rawLevel = new ArrayList<>();
        for (int i = 0; i < rowLength; i++) {
            rawLevel.add("");
        }
        for (int i = 0; i < depth; i++) {
            result.add(new ArrayList<>(rawLevel));
        }

        Queue<TreeNode> temp = new LinkedList<>();
        Queue<int[]> prevIndex = new LinkedList<>();
        temp.offer(root);
        prevIndex.offer(new int[] {0, rowLength - 1});
        while (!temp.isEmpty()) {
            len = temp.size();
            for (int i = 0; i < len; i++) {
                root = temp.poll();
                curIndex = prevIndex.poll();
                if (root != null) {
                    mid = (curIndex[1] - curIndex[0]) / 2 + curIndex[0];
                    result.get(level).set(mid, Integer.toString(root.val));
                    temp.offer(root.left);
                    temp.offer(root.right);
                    prevIndex.offer(new int[] {curIndex[0], mid - 1});
                    prevIndex.offer(new int[] {mid + 1, curIndex[1]});
                }
            }
            level++;
        }
        return result;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }
}
// @lc code=end

