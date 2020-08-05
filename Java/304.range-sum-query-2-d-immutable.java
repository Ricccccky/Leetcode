/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {

    private int[][] sumArr;
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        this.matrix = matrix;
        sumArr = new int[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < this.matrix[i].length; j++) {
                if (i > 0) {
                    sumArr[i][j] += sumArr[i - 1][j];
                }
                sum += this.matrix[i][j];
                sumArr[i][j] += sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > 0 && col1 > 0) {
            return sumArr[row2][col2] - sumArr[row1 - 1][col2] - sumArr[row2][col1 - 1] + sumArr[row1 - 1][col1 - 1];
        } else if (row1 > 0) {
            return sumArr[row2][col2] - sumArr[row1 - 1][col2];
        } else if (col1 > 0) {
            return sumArr[row2][col2] - sumArr[row2][col1 - 1];
        } else {
            return sumArr[row2][col2];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

