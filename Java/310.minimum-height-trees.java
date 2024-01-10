import java.util.*;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        List<List<Integer>> adjTable = new ArrayList<>(n);
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjTable.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjTable.get(edge[0]).add(edge[1]);
            adjTable.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (adjTable.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        // Remove leaves from each level, the # of final root cannot exceed 2, or there will be cycles
        while (n > 2) {
            List<Integer> result = new ArrayList<>();
            n -= leaves.size();
            for (Integer leaf : leaves) {
                int parent = adjTable.get(leaf).iterator().next();
                adjTable.get(parent).remove(leaf);
                if (adjTable.get(parent).size() == 1) {
                    result.add(parent);
                }
            }
            leaves = result;
        }
        return leaves;
    }
}
// @lc code=end

