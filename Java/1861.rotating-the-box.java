/*
 * @lc app=leetcode id=1861 lang=java
 *
 * [1861] Rotating the Box
 */

// @lc code=start
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            int ptr = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                result[j][m - i - 1] = '.';
                if (box[i][j] == '*') {
                    result[j][m - i - 1] = '*';
                    ptr = j - 1;
                } else if (box[i][j] == '#') {
                    result[ptr--][m - i - 1] = '#';
                }
            }
            while (ptr >= 0) {
                result[ptr--][m - i - 1] = '.';
            }
        }

        return result;
    }
}
// @lc code=end

