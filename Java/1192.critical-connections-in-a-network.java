import java.util.*;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Rmove all the edges in cycles, the left will be critical connections
        Set<List<Integer>> set = new HashSet<>(connections);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] ranks = new int[n];
        Arrays.fill(ranks, -2);
        for (List<Integer> connection : connections) {
            int e1 = connection.get(0);
            int e2 = connection.get(1);
            graph.putIfAbsent(e1, new ArrayList<>());
            graph.putIfAbsent(e2, new ArrayList<>());
            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }
        dfs(graph, 0, 0, ranks, set);
        return new ArrayList<>(set);
    }

    private int dfs(Map<Integer, List<Integer>> graph, int depth, int node, int[] ranks, Set<List<Integer>> connections) {
        if (ranks[node] >= 0) {
            // Visited node on current path
            return ranks[node];
        }
        ranks[node] = depth;
        int minDepth = depth;
        for (Integer neigh : graph.get(node)) {
            // Just visited that neighbor
            if (ranks[neigh] == depth - 1) {
                continue;
            }
            int temp = dfs(graph, depth + 1, neigh, ranks, connections);
            minDepth = Math.min(minDepth, temp);
            // Meet a node with smaller depth, edge [node, neigh] makes a cycle, discard it
            if (temp <= depth) {
                connections.remove(Arrays.asList(node, neigh));
                connections.remove(Arrays.asList(neigh, node));
            }
        }

        return minDepth;
    }
}
// @lc code=end

