/*
 * @lc app=leetcode id=323 lang=java
 *
 * [323] Number of Connected Components in an Undirected Graph
 */

// @lc code=start
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0], par) != find(edge[1], par)) {
                unite(edge[0], edge[1], par);
            }
        }
        for (int i = 0; i < n; i++) {
            if (par[i] == i) {
                result++;
            }
        }

        return result;
    }

    private int find(int node, int[] par) {
        while (node != par[node]) {
            node = par[node];
        }

        return node;
    }

    private void unite(int x, int y, int[] par) {
        par[find(x, par)] = find(y, par);
    }
}
// @lc code=end

