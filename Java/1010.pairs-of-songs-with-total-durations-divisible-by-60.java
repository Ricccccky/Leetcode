
/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        int[] count = new int[60];
        for (int t : time) {
            int r = t % 60;
            if (r != 0) {
                result += count[60 - r];
            } else {
                result += count[0];
            }
            count[r]++;
        }

        return result;
    }
}
// @lc code=end

