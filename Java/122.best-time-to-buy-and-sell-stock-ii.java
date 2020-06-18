/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < max) {
                result += max - min;
                min = prices[i];
                max = 0;
            } else if (prices[i] < min) {
                min = prices[i];
            } else {
                max = prices[i];
            }
        }
        if (max != 0) {
            result += max - min;
        }
        return result;
    }
}
// @lc code=end

