/*
 * @lc app=leetcode id=1443 lang=java
 *
 * [1443] Minimum Time to Collect All Apples in a Tree
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (edges.length == 0) {
            return 0;
        }
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

        return dfs(tree, 0, -1, hasApple);
    }

    private int dfs(List<Integer>[] tree, int node, int parent, List<Boolean> hasApple) {
        int res = 0;
        for (int child : tree[node]) {
            if (child == parent) continue;
            int childTime = dfs(tree, child, node, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                res += childTime + 2;
            }
        }

        return res;
    }
}
// @lc code=end

