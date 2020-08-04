/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int x = matrix[0].length;
        int y = matrix.length;
        int[] left = new int[x];
        int[] right = new int[x];
        int[] height = new int[x];
        int result = 0;
        for (int i =  0; i < x; i++) {
            left[i] = 0;
            right[i] = x;
            height[i] = 0;
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            int cur_left = 0;
            int cur_right = x;
            for (int j = 0; j < x; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }

            for (int j = x - 1; j > -1; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = x;
                    cur_right = j;
                }
            }

            for (int j = 0; j < x; j++) {
                if ((right[j] - left[j]) * height[j] > result) {
                    result = (right[j] - left[j]) * height[j];
                }
            }
        }
        return result;
    }
}
// @lc code=end

