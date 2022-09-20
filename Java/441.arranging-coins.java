/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2L * n + 0.25) - 0.5);
    }
}
// @lc code=end

