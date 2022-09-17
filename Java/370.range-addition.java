/*
 * @lc app=leetcode id=370 lang=java
 *
 * [370] Range Addition
 */

// @lc code=start
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        int sum = 0;
        for (int[] update : updates) {
            result[update[0]] += update[2];
            if (update[1] + 1 < length) {
                result[update[1] + 1] -= update[2];
            }
        }
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }

        return result;
    }
}
// @lc code=end

