/*
 * @lc app=leetcode id=2214 lang=java
 *
 * [2214] Minimum Health to Beat Game
 */

// @lc code=start
class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 1;
        int max = 0;
        for (int i = 0; i < damage.length; i++) {
            max = Math.max(max, damage[i]);
            sum += damage[i];
        }

        return sum - Math.min(max, armor);
    }
}
// @lc code=end

