/*
 * @lc app=leetcode id=894 lang=java
 *
 * [894] All Possible Full Binary Trees
 */

// @lc code=start

import java.util.*;

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
    private Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        for (int i = 1; i < n; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    res.add(root);
                }
            }
        }
        map.put(n, res);

        return res;
    }
}
// @lc code=end

