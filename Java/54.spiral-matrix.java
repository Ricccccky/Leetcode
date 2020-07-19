import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int row1 = 0, row2 = matrix.length - 1;
        int col1 = 0, col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            for (int i = col1; i <= col2; i++) {
                result.add(matrix[row1][i]);
            }
            row1++;

            for (int i = row1; i <= row2; i++) {
                result.add(matrix[i][col2]);
            }
            col2--;

            if (row1 <= row2) {
                for (int i = col2; i >= col1; i--) {
                    result.add(matrix[row2][i]);
                }
                row2--;
            }

            if (col1 <= col2) {
                for (int i = row2; i >= row1; i--) {
                    result.add(matrix[i][col1]);
                }
                col1++;
            }
        }
        return result;
    }
}
// @lc code=end

