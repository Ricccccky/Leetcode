/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int result = 0;
        for (int i = 0; i < right.length; i++) {
            right[i] = matrix[0].length;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            int cur_left = 0;
            int cur_right = matrix[0].length;
            for (int j = 0; j < left.length; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = right.length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = matrix[0].length;
                    cur_right = j;
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, Math.min(right[j] - left[j], height[j]) * Math.min(right[j] - left[j], height[j]));
            }
        }
        return result;
    }
}
// @lc code=end

