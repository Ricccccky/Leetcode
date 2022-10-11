import java.util.*;

/*
 * @lc app=leetcode id=827 lang=java
 *
 * [827] Making A Large Island
 */

// @lc code=start
class Solution {
    private int N = 0;
    private static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // TC: O(n^2)
    public int largestIsland(int[][] grid) {
        N = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 2, result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    map.put(idx, bfs(grid, i, j, idx));
                    result = Math.max(result, map.get(idx++));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    Set<Integer> visited = new HashSet<>();
                    for (int[] next : getNeighbor(i, j)) {
                        idx = grid[next[0]][next[1]];
                        if (idx > 1 && !visited.contains(idx)) {
                            cur += map.get(idx);
                            visited.add(idx);
                        }
                    }
                    result = Math.max(result, cur);
                }
            }
        }

        return result;
    }

    private List<int[]> getNeighbor(int i, int j) {
        List<int[]> arr = new ArrayList<>();
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < N && y >= 0 && y < N) {
                arr.add(new int[] {x, y});
            }
        }

        return arr;
    }

    private int bfs(int[][] grid, int x, int y, int idx) {
        int result = 1;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        grid[x][y] = idx;
        while (!queue.isEmpty()) {
            int[] top = queue.pop();
            for (int[] next : getNeighbor(top[0], top[1])) {
                if (grid[next[0]][next[1]] == 1) {
                    grid[next[0]][next[1]] = idx;
                    queue.offer(next);
                    result++;
                }
            }
        }

        return result;
    }
}
// @lc code=end

