import java.util.*;
/*
 * @lc app=leetcode id=311 lang=java
 *
 * [311] Sparse Matrix Multiplication
 */

// @lc code=start
class Solution {
    private class SparseMatrix {
        int row, col;
        List<Integer> values;
        List<Integer> colIndex;
        List<Integer> rowIndex;

        public SparseMatrix(int[][] mat, boolean direction) {
            row = mat.length;
            col = mat[0].length;
            values = new ArrayList<>();
            colIndex = new ArrayList<>();
            rowIndex = new ArrayList<>();
            if (direction) {
                rowIndex.add(0);
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (mat[i][j] != 0) {
                            values.add(mat[i][j]);
                            colIndex.add(j);
                        }
                    }
                    rowIndex.add(colIndex.size());
                }
            } else {
                colIndex.add(0);
                for (int j = 0; j < col; j++) {
                    for (int i = 0; i < row; i++) {
                        if (mat[i][j] != 0) {
                            values.add(mat[i][j]);
                            rowIndex.add(i);
                        }
                    }
                    colIndex.add(rowIndex.size());
                }
            }
        }

        @Override
        public String toString() {
            return values + "\n" + colIndex + "\n" + rowIndex + "\n";
        }

    }
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row = mat1.length;
        int col = mat2[0].length;
        int[][] result = new int[row][col];
        SparseMatrix m1 = new SparseMatrix(mat1, true);
        SparseMatrix m2 = new SparseMatrix(mat2, false);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int rowStart = m1.rowIndex.get(i);
                int rowEnd = m1.rowIndex.get(i + 1);
                int colStart = m2.colIndex.get(j);
                int colEnd = m2.colIndex.get(j + 1);
                while (rowStart < rowEnd && colStart < colEnd) {
                    if (m1.colIndex.get(rowStart) < m2.rowIndex.get(colStart)) {
                        rowStart++;
                    } else if (m1.colIndex.get(rowStart) > m2.rowIndex.get(colStart)) {
                        colStart++;
                    } else {
                        result[i][j] += m1.values.get(rowStart) * m2.values.get(colStart);
                        rowStart++;
                        colStart++;
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

