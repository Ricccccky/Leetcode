/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        int deltaX = coordinates[0][0] - coordinates[1][0];
        int deltaY = coordinates[0][1] - coordinates[1][1];
        for (int i = 1; i < n - 1; i++) {
            int curDeltaX = coordinates[i][0] - coordinates[i + 1][0];
            int curDeltaY = coordinates[i][1] - coordinates[i + 1][1];
            if (deltaX * curDeltaY != deltaY * curDeltaX) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

