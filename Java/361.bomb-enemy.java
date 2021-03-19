/*
 * @lc app=leetcode id=361 lang=java
 *
 * [361] Bomb Enemy
 */

// @lc code=start
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        int enemyInRow = 0;
        int[] enemyInCol = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    enemyInCol[j] = 0;
                    for (int k = i; k < row; k++) {
                        if (grid[k][j] == 'W') {
                            break;
                        } else if (grid[k][j] == 'E') {
                            enemyInCol[j]++;
                        }
                    }
                }
                if (j == 0 || grid[i][j - 1] == 'W') {
                    enemyInRow = 0;
                    for (int k = j; k < col; k++) {
                        if (grid[i][k] == 'W') {
                            break;
                        } else if (grid[i][k] == 'E') {
                            enemyInRow++;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, enemyInRow + enemyInCol[j]);
                }
            }
        }

        return res;
    }
}
// @lc code=end

