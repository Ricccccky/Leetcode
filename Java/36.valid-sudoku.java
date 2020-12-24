import java.util.HashSet;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int rowOffset = 3 * (i / 3);
                int colOffset = 3 * (i % 3);
                if (board[j / 3 + rowOffset][j % 3 + colOffset] != '.' && !cube.add(board[j / 3 + rowOffset][j % 3 + colOffset])) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

