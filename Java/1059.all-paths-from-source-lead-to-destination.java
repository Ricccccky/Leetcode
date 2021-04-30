import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1059 lang=java
 *
 * [1059] All Paths from Source Lead to Destination
 */

// @lc code=start
class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited = new int[n];
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
        }

        return dfs(map, source, destination, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int node, int destination, int[] visited) {
        if (!map.containsKey(node)) {
            return node == destination;
        }
        if (visited[node] == 1) {
            return false;
        }
        visited[node] = 1;
        for (Integer next : map.get(node)) {
            if (!dfs(map, next, destination, visited)) {
                return false;
            }
        }
        visited[node] = 2;

        return true;
    }
}
// @lc code=end

