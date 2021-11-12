import java.util.*;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> sumHist = new HashMap<>();
        sumHist.put(0, 1);

        return findPath(root, sumHist, 0, sum);
    }

    public int findPath(TreeNode root, HashMap<Integer, Integer> sumHist, int curSum, int sum) {
        if (root == null) {
            return 0;
        }
        
        int result;
        curSum += root.val;
        result = sumHist.getOrDefault(curSum - sum, 0);
        sumHist.put(curSum, sumHist.getOrDefault(curSum, 0) + 1);
        result += findPath(root.left, sumHist, curSum, sum) + findPath(root.right, sumHist, curSum, sum);
        sumHist.put(curSum, sumHist.get(curSum) - 1);
        
        return result;
    }
}
// @lc code=end

