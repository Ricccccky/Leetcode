/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int hold = -prices[0];
        int no_hold = 0;
        int pre_no_hold = 0;
        for (int price : prices) {
            int temp = hold;
            hold = Math.max(hold, pre_no_hold - price);
            pre_no_hold = no_hold;
            no_hold = Math.max(no_hold, temp + price);
        }
        return no_hold;

        // int buy = Integer.MIN_VALUE;
        // int sell = 0;
        // int cooldown = 0;
        // for (int price : prices) {
        //     int prev = sell;
        //     sell = buy + price;
        //     buy = Math.max(buy, cooldown - price);
        //     cooldown = Math.max(cooldown, prev);
        // }
        // return Math.max(sell, cooldown);
    }
}
// @lc code=end

