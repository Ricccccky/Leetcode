import java.util.*;

/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int uP = find(u, parents);
            int vP = find(v, parents);
            if (uP == vP) {
                return new int[] {u, v};
            } else {
                merge(u, v, parents);
            }
        }

        return null;
    }

    private int find(int node, int[] parents) {
        if (parents[node] < 0) {
            return node;
        }

        return parents[node] = find(parents[node], parents);
    }

    private void merge(int u, int v, int[] parents) {
        int uP = find(u, parents);
        int vP = find(v, parents);
        parents[uP] = vP;
    }
}
// @lc code=end

