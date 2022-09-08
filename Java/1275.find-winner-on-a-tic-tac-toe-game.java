/*
 * @lc app=leetcode id=1275 lang=java
 *
 * [1275] Find Winner on a Tic Tac Toe Game
 */

// @lc code=start
class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < moves.length; i++) {
            int move = i % 2 == 0 ? 1 : -1;
            int row = moves[i][0];
            int col = moves[i][1];
            if (row == col) {
                diag1 += move;
            }
            if (row + col == 2) {
                diag2 += move;
            }
            rows[row] += move;
            cols[col] += move;
            if (diag1 == 3 || diag2 == 3 || rows[row] == 3 || cols[col] == 3) {
                return "A";
            } else if (diag1 == -3 || diag2 == -3 || rows[row] == -3 || cols[col] == -3) {
                return "B";
            }
        }
        if (moves.length == 3 * 3) {
            return "Draw";
        }

        return "Pending";
    }
}
// @lc code=end

