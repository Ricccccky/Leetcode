/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int no_hold = 0;
        for (int price : prices) {
            no_hold = Math.max(no_hold, hold + price);
            hold = Math.max(hold, -price);
        }
        
        return no_hold;
        
        // int max = 0;
        // int min = prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] < min) {
        //         min = prices[i];
        //     }
        //     max = Math.max(max, prices[i] - min);
        // }
        // return max;
    }
}
// @lc code=end

