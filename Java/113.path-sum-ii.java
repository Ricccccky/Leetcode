import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList<>();
        pathTracker(root, sum, temp);
        return result;
    }

    public void pathTracker(TreeNode root, int sum, List<Integer> temp) {
        if (root == null) {
            return;
        }
        int res = sum - root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (res == 0) {
                result.add(new ArrayList<>(temp));
            }
        }
        pathTracker(root.left, res, temp);
        pathTracker(root.right, res, temp);
        temp.remove(temp.size() - 1);
    }
}
// @lc code=end

