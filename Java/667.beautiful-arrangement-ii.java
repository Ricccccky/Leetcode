/*
 * @lc app=leetcode id=667 lang=java
 *
 * [667] Beautiful Arrangement II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int p = 0;
        // n - k - 1 numbers in natural order
        for (int i = 1; i < n - k; i++) {
            res[p++] = i;
        }
        // k + 1 numbers in 1, n, 2, n - 1,... order
        for (int i = 0; i <= k; i++) {
            if (i % 2 == 0) {
                res[p++] = n - k + i / 2;
            } else {
                res[p++] = n - i / 2;
            }
        }

        return res;
    }
}
// @lc code=end

