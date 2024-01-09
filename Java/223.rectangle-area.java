/*
 * @lc app=leetcode id=223 lang=java
 *
 * [223] Rectangle Area
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int res = (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1);
        int xOverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yOverlap = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (xOverlap > 0 && yOverlap > 0) {
            res -= xOverlap * yOverlap;
        }

        return res;
    }
}
// @lc code=end

