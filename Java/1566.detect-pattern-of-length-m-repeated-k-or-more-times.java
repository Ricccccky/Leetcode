/*
 * @lc app=leetcode id=1566 lang=java
 *
 * [1566] Detect Pattern of Length M Repeated K or More Times
 */

// @lc code=start
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - m; i++) {
            if (arr[i] == arr[i + m]) {
                count++;
            } else {
                count = 0;
            }
            if (count == m * (k - 1)) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

