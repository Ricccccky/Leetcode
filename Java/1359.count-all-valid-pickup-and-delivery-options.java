/*
 * @lc app=leetcode id=1359 lang=java
 *
 * [1359] Count All Valid Pickup and Delivery Options
 */

// @lc code=start
class Solution {
    public int countOrders(int n) {
        int mod = 1000000007;
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i * (2 * i - 1) % mod;
        }

        return (int)res;
    }
}
// @lc code=end

