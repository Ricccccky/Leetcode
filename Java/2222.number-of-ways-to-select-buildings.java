/*
 * @lc app=leetcode id=2222 lang=java
 *
 * [2222] Number of Ways to Select Buildings
 */

// @lc code=start
class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        long result = 0;
        char[] arr = s.toCharArray();
        int[] zeros = new int[n];
        int[] ones = new int[n];
        int one = 0, zero = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                ones[i] = one;
                zero++;
            } else {
                zeros[i] = zero;
                one++;
            }
        }
        one = 0;
        zero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                result += one * ones[i];
                zero++;
            } else {
                result += zero * zeros[i];
                one++;
            }
        }

        return result;
    }
}
// @lc code=end

