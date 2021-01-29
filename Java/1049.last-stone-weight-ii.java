/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
            for (int i = Math.min(sum, 1500); i >= stone; i--) {
                dp[i] |= dp[i - stone];
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[i]) {
                return sum - i - i;
            }
        }

        return 0;
    }
}
// @lc code=end

