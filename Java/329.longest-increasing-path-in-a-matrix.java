/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        int len;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                len = dfs(matrix, i, j, visited);
                result = Math.max(result, len);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] visited) {
        if (visited[row][col] != 0) {
            return visited[row][col];
        }
        int max = 1;
        if (row + 1 < matrix.length && row + 1 >= 0 && col >= 0 && col < matrix[0].length && matrix[row + 1][col] > matrix[row][col]) {
            max = Math.max(max, 1 + dfs(matrix, row + 1, col, visited));
        }
        if (row - 1 < matrix.length && row - 1 >= 0 && col >= 0 && col < matrix[0].length && matrix[row - 1][col] > matrix[row][col]) {
            max = Math.max(max, 1 + dfs(matrix, row - 1, col, visited));
        }
        if (row < matrix.length && row >= 0 && col + 1 >= 0 && col + 1 < matrix[0].length && matrix[row][col + 1] > matrix[row][col]) {
            max = Math.max(max, 1 + dfs(matrix, row, col + 1, visited));
        }
        if (row < matrix.length && row >= 0 && col - 1 >= 0 && col - 1 < matrix[0].length && matrix[row][col - 1] > matrix[row][col]) {
            max = Math.max(max, 1 + dfs(matrix, row, col - 1, visited));
        }
        visited[row][col] = max;
        return max;
    }
}
// @lc code=end

