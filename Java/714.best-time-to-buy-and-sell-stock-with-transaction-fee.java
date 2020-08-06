/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int hold = -prices[0];
        int no_hold = 0;
        for (int price : prices) {
            int temp = hold;
            hold = Math.max(hold, no_hold - price);
            no_hold = Math.max(no_hold, temp + price - fee);
        }
        return no_hold;
    }
}
// @lc code=end

