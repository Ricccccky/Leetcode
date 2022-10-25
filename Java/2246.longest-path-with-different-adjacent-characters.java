import java.util.*;

/*
 * @lc app=leetcode id=2246 lang=java
 *
 * [2246] Longest Path With Different Adjacent Characters
 */

// @lc code=start
class Solution {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        int result = 0;
        int[] paths = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }
        dfs(graph, 0, paths, s);
        for (int path : paths) {
            result = Math.max(path, result);
        }

        return result;
    }

    private int dfs(List<Integer>[] graph, int node, int[] paths, String s) {
        int first = 0;
        int second = 0;
        for (int neighbor : graph[node]) {
            int tmp = dfs(graph, neighbor, paths, s);
            if (s.charAt(node) == s.charAt(neighbor)) {
                continue;
            }
            if (tmp > first) {
                second = first;
                first = tmp;
            } else if (tmp > second) {
                second = tmp;
            }
        }
        paths[node] = first + second + 1;

        return first + 1;
    }
}
// @lc code=end

