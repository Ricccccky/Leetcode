import java.util.*;

/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        int[] dp = new int[maxNum + 1];
        dp[1] = count.getOrDefault(1, 0);
        for (int i = 2; i < dp.length; i++) {
            int earn = count.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + earn);
        }

        return dp[maxNum];
    }
}
// @lc code=end

