/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Set<List<Integer>> set = new HashSet<>(connections);
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < connections.size(); i++) {
            int e1 = connections.get(i).get(0);
            int e2 = connections.get(i).get(1);
            map.putIfAbsent(e1, new ArrayList<>());
            map.putIfAbsent(e2, new ArrayList<>());
            map.get(e1).add(e2);
            map.get(e2).add(e1);
        }
        int[] ranks = new int[n];
        Arrays.fill(ranks, -2);
        dfs(map, 0, 0, ranks, set);
        return new ArrayList<>(set);
    }

    private int dfs(Map<Integer, List<Integer>> graph, int depth, int node, int[] ranks, Set<List<Integer>> connections) {
        if (ranks[node] >= 0) {
            return ranks[node];
        }
        ranks[node] = depth;
        int minDepth = depth;
        for (Integer neigh : graph.get(node)) {
            if (ranks[neigh] == depth - 1) {
                continue;
            }
            int temp = dfs(graph, depth + 1, neigh, ranks, connections);
            minDepth = Math.min(minDepth, temp);
            if (temp <= depth) {
                connections.remove(Arrays.asList(node, neigh));
                connections.remove(Arrays.asList(neigh, node));
            }
        }
        return minDepth;
    }
}
// @lc code=end

