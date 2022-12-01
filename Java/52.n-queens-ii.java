/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        return backtracking(0, n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }
    
    private int backtracking(int row, int n, boolean[] col,  boolean[] diag, boolean[] back) {
        if (row == n) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (col[i] || diag[row - i + n - 1] || back[row + i]) {
                continue;
            }
            col[i] = true;
            diag[row - i + n - 1] = true;
            back[row + i] = true;
            result += backtracking(row + 1, n, col, diag, back);
            col[i] = false;
            diag[row - i + n - 1] = false;
            back[row + i] = false;
        }
        
        return result;
    }
}
// @lc code=end

