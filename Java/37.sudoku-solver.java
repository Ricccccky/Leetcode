/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtracking(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == c) {
                return false;
            }
            if (board[i][y] == c) {
                return false;
            }
            if (board[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == c) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

