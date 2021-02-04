/*
 * @lc app=leetcode id=272 lang=java
 *
 * [272] Closest Binary Search Tree Value II
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair<Double, Integer>> queue = new PriorityQueue<>((d1, d2) -> Double.compare(d2.getKey(), d1.getKey()));
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.addFirst(root);
                root = root.left;
            } else {
                root = stack.removeFirst();
                if (queue.size() == k && Math.abs(root.val - target) > queue.peek().getKey()) {
                    break;
                }
                queue.add(new Pair<>(Math.abs(root.val - target), root.val));
                if (queue.size() > k) {
                    queue.poll();
                }
                root = root.right;
            }
        }
        
        for (Pair<Double, Integer> pair : queue) {
            res.add(pair.getValue());
        }
        return res;
    }
}
// @lc code=end

