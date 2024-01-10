/*
 * @lc app=leetcode id=1245 lang=java
 *
 * [1245] Tree Diameter
 */

// @lc code=start

import java.util.*;

class Solution {
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        int n = edges.length + 1, res = 0;
        int[] diameters = new int[n];
        List<Integer>[] tree = new List[n];
        for (int[] edge : edges) {
            if (tree[edge[0]] == null) {
                tree[edge[0]] = new ArrayList<>();
            }
            if (tree[edge[1]] == null) {
                tree[edge[1]] = new ArrayList<>();
            }
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        dfs(tree, 0, -1, diameters);
        for (int d : diameters) {
            res = Math.max(res, d);
        }

        return res;
    }

    private int dfs(List<Integer>[] tree, int node, int parent, int[] diameters) {
        int depth1 = 0, depth2 = 0;
        for (int child : tree[node]) {
            if (child == parent) continue;
            int depth = dfs(tree, child, node, diameters);
            if (depth > depth1) {
                depth2 = depth1;
                depth1 = depth;
            } else if (depth > depth2) {
                depth2 = depth;
            }
        }
        int diameter = depth1 + depth2;
        diameters[node] = diameter;

        return depth1 + 1;
    }
}
// @lc code=end

