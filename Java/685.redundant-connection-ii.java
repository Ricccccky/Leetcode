import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */

// @lc code=start
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] prev = new int[edges.length + 1];
        int[] inDegree = new int[edges.length + 1];
        int badNode = -1;
        int[] result = new int[2];
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            inDegree[i] = 0;
            prev[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
            if (inDegree[edges[i][1]] > 1) {
                badNode = edges[i][1];
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == badNode) {
                temp.add(edges[i]);
                continue;
            }
            int u = edges[i][0];
            int v = edges[i][1];
            int uAnce = findAncestor(prev, u);
            int vAnce = findAncestor(prev, v);
            if (uAnce != vAnce) {
                prev[vAnce] = uAnce;
            } else {
                result = new int[] {u, v};
            }
        }
        for (int[] badEdge : temp) {
            int u = badEdge[0];
            int v = badEdge[1];
            int uAnce = findAncestor(prev, u);
            int vAnce = findAncestor(prev, v);
            if (uAnce != vAnce) {
                prev[vAnce] = uAnce;
            } else {
                result = new int[] {u, v};
            }
        }
        return result;
    }

    private int findAncestor(int[] prev, int cur) {
        while (prev[cur] != cur) {
            cur = prev[cur];
        }
        return cur;
    }
}
// @lc code=end

