import java.util.Arrays;

/*
 * @lc app=leetcode id=1135 lang=java
 *
 * [1135] Connecting Cities With Minimum Cost
 */

// @lc code=start
class Solution {
    public int minimumCost(int N, int[][] connections) {
        int[] parent = new int[N + 1];
        int count = N;
        int res = 0;
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        Arrays.sort(connections, (x, y) -> Integer.compare(x[2], y[2]));
        for (int[] c : connections) {
            int x = c[0];
            int y = c[1];
            if (find(x, parent) != find(y, parent)) {
                count--;
                res += c[2];
                union(x, y, parent);
            }
        }

        return count == 1 ? res : -1;
    }

    private int find(int x, int[] parent) {
        while (parent[x] != x) {
            x = parent[x];
        }

        return x;
    }

    private void union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        
        if (px != py) {
            parent[px] = py;
        }
    }
}
// @lc code=end

