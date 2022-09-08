/*
 * @lc app=leetcode id=348 lang=java
 *
 * [348] Design Tic-Tac-Toe
 */

// @lc code=start
class TicTacToe {
    private int[] rows;
    private int[] columns;
    private int diag1, diag2, n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        columns = new int[n];
        diag1 = 0;
        diag2 = 0;
    }
    
    public int move(int row, int col, int player) {
        int m = player == 1 ? 1 : -1;
        if (row == col) {
            diag1 += m;
        }
        if (row + col == n - 1) {
            diag2 += m;
        }
        rows[row] += m;
        columns[col] += m;
        if (diag1 == n || diag2 == n || rows[row] == n || columns[col] == n) {
            return 1;
        } else if (diag1 == -n || diag2 == -n || rows[row] == -n || columns[col] == -n) {
            return 2;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
// @lc code=end

