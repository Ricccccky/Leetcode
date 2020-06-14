/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] prev = new int[edges.length + 1];
        int[] result = new int[2];
        for (int i = 0; i <= edges.length; i++) {
            prev[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int uAnce = findAncestor(u, prev);
            int vAnce = findAncestor(v, prev);
            if (uAnce != vAnce) {
                prev[vAnce] = uAnce;
            } else {
                result = new int[] {u, v};
            }
        }
        return result;
    }

    private int findAncestor(int cur, int[] prev) {
        while (prev[cur] != cur) {
            cur = prev[cur];
        }
        return cur;
    }
}
// @lc code=end

