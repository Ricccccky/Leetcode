/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(parents, edge[0]);
            int y = find(parents, edge[1]);
            if (x == y) {
                return false;
            }
            parents[x] = y;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                count++;
            }
        }
        return count <= 1;
    }

    private int find(int[] parents, int node) {
        while (parents[node] != node) {
            node = parents[node];
        }

        return node;
    }
}
// @lc code=end

