import java.util.*;

/*
 * @lc app=leetcode id=694 lang=java
 *
 * [694] Number of Distinct Islands
 */

// @lc code=start
class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    res.add(sb.toString());
                }
            }
        }
        
        return res.size();
    }
    
    private void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] paths = new String[] {"U", "D", "L", "R"};
        grid[i][j] = 0;
        for (int k = 0; k < dirs.length; k++) {
            int x = dirs[k][0] + i;
            int y = dirs[k][1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                sb.append(paths[k]);
                dfs(grid, x, y, sb);
            }
        }
        sb.append("0");
    }
}
// @lc code=end

