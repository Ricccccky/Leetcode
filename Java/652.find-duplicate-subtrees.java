import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        HashMap<String, Integer> data = new HashMap<>();
        serializeNode(root, data, result);
        return result;
    }

    private String serializeNode(TreeNode root, HashMap<String, Integer> data, List<TreeNode> result) {
        if (root == null) {
            return "null";
        }
        String subtree = root.val + "," + serializeNode(root.left, data, result) + "," + serializeNode(root.right, data, result);
        if (data.getOrDefault(subtree, 0) == 1) {
            result.add(root);
        }
        data.put(subtree, data.getOrDefault(subtree, 0) + 1);
        return subtree;
    }
}
// @lc code=end

