import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        dfs(root, freq);
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> k : freq.entrySet()) {
            if (k.getValue() > maxFreq) {
                result.clear();
                result.add(k.getKey());
                maxFreq = k.getValue();
            } else if (k.getValue() == maxFreq) {
                result.add(k.getKey());
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int dfs(TreeNode root, HashMap<Integer, Integer> result) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        sum += dfs(root.left, result);
        sum += dfs(root.right, result);
        if (result.containsKey(sum)) {
            result.put(sum, result.get(sum) + 1);
        } else {
            result.put(sum, 1);
        }
        return sum;
    }
}
// @lc code=end

