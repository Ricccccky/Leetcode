/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return PredictTheWinner(nums, 0, nums.length - 1, 1) >= 0;
    }

    private int PredictTheWinner(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return turn * nums[start];
        }
        int s = turn * nums[start] + PredictTheWinner(nums, start + 1, end, -turn);
        int e = turn * nums[end] + PredictTheWinner(nums, start, end - 1, -turn);

        return turn == 1 ? Math.max(s, e) : Math.min(s, e);
    }
}
// @lc code=end

