import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=711 lang=java
 *
 * [711] Number of Distinct Islands II
 */

// @lc code=start
class Solution {
    public int numDistinctIslands2(int[][] grid) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> cells = new LinkedList<>();
                    dfs(grid, i, j, cells);
                    res.add(transform(cells));
                }
            }
        }

        return res.size();
    }

    private String transform(List<int[]> cells) {
        TreeSet<String> set = new TreeSet<>();
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                List<int[]> l1 = new ArrayList<>();
                List<int[]> l2 = new ArrayList<>();
                for (int[] cell : cells) {
                    l1.add(new int[] {i * cell[0], j * cell[1]});
                    l2.add(new int[] {i * cell[1], j * cell[0]});
                }
                for (List<int[]> l : Arrays.asList(l1, l2)) {
                    l.sort((p1, p2) -> p1[0] != p2[0] ? Integer.compare(p1[0], p2[0]) : Integer.compare(p1[1], p2[1]));
                    int x = l.get(0)[0];
                    int y = l.get(0)[1];
                    StringBuilder sb = new StringBuilder();
                    for (int[] p : l) {
                        sb.append(p[0] - x)
                        .append(":")
                        .append(p[1] - y)
                        .append(":");
                    }
                    set.add(sb.toString());
                }
            }
        }

        return set.first();
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> cells) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        cells.add(new int[] {i, j});
        grid[i][j] = -1;
        dfs(grid, i + 1, j, cells);
        dfs(grid, i - 1, j, cells);
        dfs(grid, i, j + 1, cells);
        dfs(grid, i, j - 1, cells);
    }
}
// @lc code=end

