/*
 * @lc app=leetcode id=1274 lang=java
 *
 * [1274] Number of Ships in a Rectangle
 */

// @lc code=start
/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return 1;
        }
        int mid_x = (topRight[0] + bottomLeft[0]) / 2;
        int mid_y = (topRight[1] + bottomLeft[1]) / 2;

        return countShips(sea, topRight, new int[] {mid_x + 1, mid_y + 1}) 
            + countShips(sea, new int[] {mid_x, mid_y}, bottomLeft)
            + countShips(sea, new int[] {mid_x, topRight[1]}, new int[] {bottomLeft[0], mid_y + 1})
            + countShips(sea, new int[] {topRight[0], mid_y}, new int[] {mid_x + 1, bottomLeft[1]});
    }
}
// @lc code=end

