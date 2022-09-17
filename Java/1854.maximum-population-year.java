/*
 * @lc app=leetcode id=1854 lang=java
 *
 * [1854] Maximum Population Year
 */

// @lc code=start
class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[2051];
        int result = 0;
        for (int[] log : logs) {
            years[log[0]]++;
            years[log[1]]--;
        }
        for (int i = 1950; i <= 2050; i++) {
            years[i] += years[i - 1];
            if (years[i] > years[result]) {
                result = i;
            }
        }

        return result;
    }
}
// @lc code=end

