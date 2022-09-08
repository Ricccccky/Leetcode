/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int result = n;
        int onesBefore = 0, zerosAfter = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zerosAfter++;
            }
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zerosAfter--;
            }
            result = Math.min(result, onesBefore + zerosAfter);
            if (c == '1') {
                onesBefore++;
            }
        }

        return result;
    }
}
// @lc code=end

