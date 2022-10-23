import java.util.*;

/*
 * @lc app=leetcode id=749 lang=java
 *
 * [749] Contain Virus
 */

// @lc code=start
class Solution {
    private class Region implements Comparable<Region> {
        Set<Integer> infected;
        Set<Integer> uninfected;
        int walls;

        public Region() {
            infected = new HashSet<>();
            uninfected = new HashSet<>();
            walls = 0;
        }

        @Override
        public int compareTo(Region o) {
            return o.uninfected.size() - this.uninfected.size();
        };
    }

    public int containVirus(int[][] isInfected) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        int result = 0;
        while (true) {
            boolean[][] visited = new boolean[m][n];
            List<Region> regions = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        Region region = new Region();
                        dfs(region, isInfected, i, j, visited);
                        regions.add(region);
                    }
                }
            }
            if (regions.size() == 0) {
                break;
            }
            Collections.sort(regions);
            Region topRegion = regions.remove(0);
            result += topRegion.walls;
            for (int neighbor : topRegion.infected) {
                int x = neighbor / n;
                int y = neighbor % n;
                isInfected[x][y] = 2;
            }
            for (Region region : regions) {
                for (int neighbor : region.uninfected) {
                    int x = neighbor / n;
                    int y = neighbor % n;
                    isInfected[x][y] = 1;
                }
            }
        }

        return result;
    }

    private void dfs(Region region, int[][] isInfected, int x, int y, boolean[][] visited) {
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = isInfected.length;
        int n = isInfected[0].length;
        if (isInfected[x][y] == 1 && !visited[x][y]) {
            region.infected.add(x * n + y);
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n) {
                    dfs(region, isInfected, i, j, visited);
                }
            }
        } else if (isInfected[x][y] == 0) {
            region.walls++;
            region.uninfected.add(x * n + y);
        }
    }
}
// @lc code=end

