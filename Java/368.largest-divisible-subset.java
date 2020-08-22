import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        int maxNum = 0;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxNum) {
                maxNum = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return result;
    }
}
// @lc code=end

