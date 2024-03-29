import java.util.*;

/*
 * @lc app=leetcode id=314 lang=java
 *
 * [314] Binary Tree Vertical Order Traversal
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> columns = new HashMap<>();
        Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int left = 1, right = 0;
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            int col = p.getValue();
            if (root != null) {
                columns.putIfAbsent(col, new ArrayList<>());
                left = Math.min(left, col);
                right = Math.max(right, col);
                columns.get(col).add(root.val);
                queue.offer(new Pair<>(root.left, col - 1));
                queue.offer(new Pair<>(root.right, col + 1));
            }
        }
        for (int i = left; i <= right; i++) {
            result.add(columns.get(i));
        }
        
        return result;
    }
}
// @lc code=end

