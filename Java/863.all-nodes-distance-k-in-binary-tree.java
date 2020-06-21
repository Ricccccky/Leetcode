import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        traversal(root, target, map);
        dfs(root, target, K, 0, result, map);
        return result;
    }

    private int traversal(TreeNode root, TreeNode target, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return -1;
        }
        if (root.val == target.val) {
            map.put(root, 0);
            return 0;
        }
        int leftDistance = traversal(root.left, target, map);
        if (leftDistance >= 0) {
            map.put(root, leftDistance + 1);
            return leftDistance + 1;
        }
        int rightDistance = traversal(root.right, target, map);
        if (rightDistance >= 0) {
            map.put(root, rightDistance + 1);
            return rightDistance + 1;
        }
        return -1;
    }

    private void dfs (TreeNode root, TreeNode target, int K, int distance, List<Integer> result, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root)) {
            distance = map.get(root);
        }
        if (distance == K) {
            result.add(root.val);
        }
        dfs(root.left, target, K, distance + 1, result, map);
        dfs(root.right, target, K, distance + 1, result, map);
    }
}
// @lc code=end

