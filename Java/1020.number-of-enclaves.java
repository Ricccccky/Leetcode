/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                dfs(A, i, 0);
            }
            if (A[i][A[0].length - 1] == 1) {
                dfs(A, i, A[0].length - 1);
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            if (A[0][i] == 1) {
                dfs(A, 0, i);
            }
            if (A[A.length - 1][i] == 1) {
                dfs(A, A.length - 1, i);
            }
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] A, int row, int col) {
        if (row >= 0 && row < A.length && col >= 0 && col < A[row].length && A[row][col] == 1) {
            A[row][col] = 0;
            dfs(A, row + 1, col);
            dfs(A, row - 1, col);
            dfs(A, row, col + 1);
            dfs(A, row, col - 1);
        }
    }
}
// @lc code=end

