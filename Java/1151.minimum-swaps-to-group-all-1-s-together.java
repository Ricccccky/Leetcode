/*
 * @lc app=leetcode id=1151 lang=java
 *
 * [1151] Minimum Swaps to Group All 1's Together
 */

// @lc code=start
class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        int result = n;
        int len = 0, l = 0, r = 0;
        int ones = 0;
        for (int num : data) {
            if (num == 1) {
                len++;
            }
        }
        if (len == 0) {
            return 0;
        }
        while (r < n) {
            if (data[r] == 1) {
                ones++;
            }
            r++;
            if (r - l == len) {
                result = Math.min(result, len - ones);
                if (data[l] == 1) {
                    ones--;
                }
                l++;
            }
        }

        return result;
    }
}
// @lc code=end

