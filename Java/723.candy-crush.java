/*
 * @lc app=leetcode id=723 lang=java
 *
 * [723] Candy Crush
 */

// @lc code=start
class Solution {
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean crushed = true;
        while (crushed) {
            crushed = false;
            // Check each column, from left to right
            for (int i = 0; i < row - 2; i++) {
                for (int j = 0; j < col; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val != 0 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                        board[i][j] = -val;
                        board[i + 1][j] = -val;
                        board[i + 2][j] = -val;
                        crushed = true;
                    }
                }
            }
            // Check each row, from top to bottom
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col - 2; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val != 0 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                        board[i][j] = -val;
                        board[i][j + 1] = -val;
                        board[i][j + 2] = -val;
                        crushed = true;
                    }
                }
            }
            // Drop
            for (int i = 0; i < col; i++) {
                int ptr = row - 1;
                for (int j = row - 1; j >= 0; j--) {
                    if (board[j][i] > 0) {
                        board[ptr--][i] = board[j][i];
                    }
                }
                while (ptr >= 0) {
                    board[ptr--][i] = 0;
                }
            }
        }

        return board;
    }
}
// @lc code=end

