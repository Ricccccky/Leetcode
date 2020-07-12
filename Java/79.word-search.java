/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean result = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, word, new boolean[board.length][board[i].length], i, j, 1);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] board, String word, boolean[][] used, int row, int col, int index) {
        if (index == word.length()) {
            result = true;
            return;
        }
        used[row][col] = true;
        if (row - 1 >= 0 && board[row - 1][col] == word.charAt(index) && !used[row - 1][col] && !result) {
            dfs(board, word, used, row - 1, col, index + 1);
            used[row - 1][col] = false;
        }
        if (row + 1 < board.length && board[row + 1][col] == word.charAt(index) && !used[row + 1][col] && !result) {
            dfs(board, word, used, row + 1, col, index + 1);
            used[row + 1][col] = false;
        }
        if (col - 1 >= 0 && board[row][col - 1] == word.charAt(index) && !used[row][col - 1] && !result) {
            dfs(board, word, used, row, col - 1, index + 1);
            used[row][col - 1] = false;
        }
        if (col + 1 < board[row].length && board[row][col + 1] == word.charAt(index) && !used[row][col + 1] && !result) {
            dfs(board, word, used, row, col + 1, index + 1);
            used[row][col + 1] = false;
        }
    }
}
// @lc code=end

