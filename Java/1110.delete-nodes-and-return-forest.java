import java.util.Set;

/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> to_deleteSet = new HashSet<>();
        for (int t : to_delete) {
            to_deleteSet.add(t);
        }
        if (!to_deleteSet.contains(root.val)) {
            result.add(root);
        }
        findDelete(root, to_deleteSet, result);
        return result;
    }

    private TreeNode findDelete(TreeNode root, Set<Integer> to_deleteSet, List<TreeNode> result) {
        if (root == null) {
            return null;
        }
        root.left = findDelete(root.left, to_deleteSet, result);
        root.right = findDelete(root.right, to_deleteSet, result);
        if (to_deleteSet.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
}
// @lc code=end

