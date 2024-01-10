/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, cnt = 0;
        // Impossible to discard more majority elements than minority elements
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                cnt++;
            } else if (num == res) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return res;
    }
}
// @lc code=end

