/*
 * @lc app=leetcode id=657 lang=java
 *
 * [657] Robot Return to Origin
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int[] dirs = new int[4];
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                dirs[0]++;
            } else if (c == 'D') {
                dirs[1]++;
            } else if (c == 'L') {
                dirs[2]++;
            } else {
                dirs[3]++;
            }
        }

        return dirs[0] == dirs[1] && dirs[2] == dirs[3];
    }
}
// @lc code=end

