import java.util.*;

/*
 * @lc app=leetcode id=305 lang=java
 *
 * [305] Number of Islands II
 */

// @lc code=start
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] parents = new int[m * n];
        int count = 0;
        Arrays.fill(parents, -1);
        for (int[] pos : positions) {
            int parent = pos[0] * n + pos[1];
            if (parents[parent] == -1) {
                parents[parent] = parent;
                count++;
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    int next = x * n + y;
                    if (x < 0 || x >= m || y < 0 || y >= n || parents[next] == -1) {
                        continue;
                    }
                    int nextParent = find(parents, next);
                    if (nextParent != parent) {
                        parents[parent] = nextParent;
                        parent = nextParent;
                        count--;
                    }
                }
            }
            res.add(count);
        }

        return res;
    }

    private int find(int[] parents, int cell) {
        while (cell != parents[cell]) {
            parents[cell] = parents[parents[cell]];
            cell = parents[cell];
        }

        return cell;
    }
}
// @lc code=end

