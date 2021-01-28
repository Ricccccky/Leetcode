import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] back = new boolean[2 * n - 1];
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracking(0, n, res, col, diag, back, board);

        return res;
    }

    private void backtracking(int row, int n, List<List<String>> res, boolean[] col, boolean[] diag, boolean[] back, char[][] board) {
        if (row == n) {
            List<String> solu = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solu.add(String.valueOf(board[i]));
            }
            res.add(solu);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || diag[row - i + n - 1] || back[row + i]) {
                continue;
            }
            col[i] = true;
            diag[row - i + n - 1] = true;
            back[row + i] = true;
            board[row][i] = 'Q';
            backtracking(row + 1, n, res, col, diag, back, board);
            col[i] = false;
            diag[row - i + n - 1] = false;
            back[row + i] = false;
            board[row][i] = '.';
        }
    }
}
// @lc code=end

