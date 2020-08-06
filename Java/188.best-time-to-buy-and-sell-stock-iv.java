import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int hold = -prices[0];
            int no_hold = 0;
            for (int price : prices) {
                int temp = hold;
                hold = Math.max(hold, no_hold - price);
                no_hold = Math.max(no_hold, temp + price);
            }
            return no_hold;
        }

        int[] hold = new int[k + 1];
        int[] no_hold = new int[k + 1];
        Arrays.fill(hold, -prices[0]);
        for (int price : prices) {
            for (int i = k; i > 0; i--) {
                hold[i] = Math.max(hold[i], no_hold[i - 1] - price);
                no_hold[i] = Math.max(no_hold[i], hold[i] + price);
            }
        }
        return no_hold[k];
    }
}
// @lc code=end

