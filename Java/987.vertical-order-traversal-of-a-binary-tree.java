import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    private int maxX = 0, minX = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
        dfs(root, 0, 0, map);
        for (int i = minX; i <= maxX; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int key : map.get(i).keySet()) {
                while (!map.get(i).get(key).isEmpty()) {
                    temp.add(map.get(i).get(key).poll());
                }
            }
            result.add(temp);
        }
        return result;
    }

    private void dfs(TreeNode root, int x, int y, Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<Integer>());
        }
        map.get(x).get(y).add(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}
// @lc code=end

