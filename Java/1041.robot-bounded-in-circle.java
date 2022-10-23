/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int face = 0;
        for (char i : instructions.toCharArray()) {
            if (i == 'L') {
                face = (face + 3) % 4;
            } else if (i == 'R') {
                face = (face + 1) % 4;
            } else {
                x += dirs[face][0];
                y += dirs[face][1];
            }
        }

        return (x == 0 && y == 0) || face != 0;
    }
}
// @lc code=end

