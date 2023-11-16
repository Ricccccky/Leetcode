/*
 * @lc app=leetcode id=2139 lang=java
 *
 * [2139] Minimum Moves to Reach Target Score
 */

// @lc code=start
class Solution {
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target > 1) {
            if (maxDoubles-- > 0) {
                if (target % 2 == 0) {
                    target /= 2;
                } else {
                    target -= 1;
                    target /= 2;
                    res++;
                }
                res++;
            } else {
                res += target - 1;
                break;
            }
        }

        return res;
    }
}
// @lc code=end

