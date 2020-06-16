import java.util.Arrays;

/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 */

// @lc code=start
class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], 1);
        }
        for (int i = 0; i < mines.length; i++) {
            matrix[mines[i][0]][mines[i][1]] = 0;
        }
        int count;
        int result = 0;
        for (int i = 0; i < N; i++) {
            count = 0;
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                matrix[i][j] = count;
            }

            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    count ++;
                } else {
                    count = 0;
                }
                matrix[i][j] = Math.min(matrix[i][j], count);
            }
        }
        for (int i = 0; i < N; i++) {
            count = 0;
            for (int j = 0; j < N; j++) {
                if (matrix[j][i] != 0) {
                    count ++;
                } else {
                    count = 0;
                }
                matrix[j][i] = Math.min(matrix[j][i], count);
            }

            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[j][i] != 0) {
                    count ++;
                } else {
                    count = 0;
                }
                matrix[j][i] = Math.min(matrix[j][i], count);
                result = Math.max(matrix[j][i], result);
            }
        }
        return result;
    }
}
// @lc code=end

