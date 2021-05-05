import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=1676 lang=java
 *
 * [1676] Lowest Common Ancestor of a Binary Tree IV
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node.val);
        }

        return lowestCommonAncestor(root, set);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root.val)) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, set);
        TreeNode r = lowestCommonAncestor(root.right, set);
        if (l == null && r == null) {
            return null;
        } else if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else {
            return r;
        }
    }
}
// @lc code=end

