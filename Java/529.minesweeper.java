/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length, row = click[0], col = click[1];
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int cnt = 0;
            for (int[] dir : dirs) {
                int x = row + dir[0], y = col + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 'M' || board[x][y] == 'X')) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                board[row][col] = 'B';
                for (int[] dir : dirs) {
                    int x = row + dir[0], y = col + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'E') {
                        updateBoard(board, new int[] {x, y});
                    }
                }
            } else {
                board[row][col] = (char)(cnt + '0');
            }
        }

        return board;
    }
}
// @lc code=end

