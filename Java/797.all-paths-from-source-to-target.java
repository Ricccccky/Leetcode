import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        path.add(0);
        for (int i = 0; i < graph[0].length; i++) {
            int next = graph[0][i];
            path.add(next);
            visited[next] = true;
            dfs(graph, next, res, path, visited);
            visited[next] = false;
            path.remove(path.size() - 1);
        }

        return res;
    }

    private void dfs(int[][] graph, int start, List<List<Integer>> res, List<Integer> path, boolean[] visited) {
        int n = graph.length;
        if (start == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[start].length; i++) {
            int next = graph[start][i];
            visited[next] = true;
            path.add(next);
            dfs(graph, next, res, path, visited);
            path.remove(path.size() - 1);
            visited[next] = false;
        }
    }
}
// @lc code=end

