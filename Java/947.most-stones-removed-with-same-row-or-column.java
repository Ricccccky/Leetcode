import java.util.*;

/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int components = 0;
        List<Integer>[] graph = new List[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  
                components++;
                dfs(graph, visited, i);
            }
        }

        return n - components;
    }

    private void dfs(List<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }
}
// @lc code=end

