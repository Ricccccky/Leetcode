/*
 * @lc app=leetcode id=1323 lang=java
 *
 * [1323] Maximum 69 Number
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        int RL = (int)Math.pow(10, String.valueOf(num).length() - 1);
        while (RL > 0) {
            if (num / RL % 10 == 6) {
                num += RL * 3;
                break;
            }
            RL /= 10;
        }

        return num;
    }
}
// @lc code=end

