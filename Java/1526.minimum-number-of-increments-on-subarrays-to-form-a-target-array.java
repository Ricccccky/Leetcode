/*
 * @lc app=leetcode id=1526 lang=java
 *
 * [1526] Minimum Number of Increments on Subarrays to Form a Target Array
 */

// @lc code=start
class Solution {
    public int minNumberOperations(int[] target) {
        int res = 0;
        int cur = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] > cur) {
                res += target[i] - cur;
            }
            cur = target[i];
        }

        return res;
    }
}
// @lc code=end

