import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Topology sort
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] p : prerequisites) {
            int pre = p[1];
            int course = p[0];
            graph.get(pre).add(course);
            indegree[course]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            res.add(top);
            for (int next : graph.get(top)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (res.size() != numCourses) {
            return new int[0];
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();

        // DFS
        // Map<Integer, Set<Integer>> map = new HashMap<>();
        // int[] visited = new int[numCourses];
        // List<Integer> res = new ArrayList<>();
        // for (int i = 0; i < prerequisites.length; i++) {
        //     int parent = prerequisites[i][1];
        //     int child = prerequisites[i][0];
        //     map.putIfAbsent(child, new HashSet<>());
        //     map.get(child).add(parent);
        // }
        // for (int i = 0; i < numCourses; i++) {
        //     if (dfs(map, visited, i, res)) {
        //         return new int[0];
        //     }
        // }

        // return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, int[] visited, int node, List<Integer> res) {
        // Gray
        if (visited[node] == 1) {
            return true;
        }
        // Black
        if (visited[node] == 2) {
            return false;
        }
        visited[node] = 1;
        for (Integer parent : map.getOrDefault(node, new HashSet<>())) {
            if (dfs(map, visited, parent, res)) {
                return true;
            }
        }
        visited[node] = 2;
        res.add(node);

        return false;
    }
}
// @lc code=end

