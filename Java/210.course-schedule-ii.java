import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Topology sort
        // int[][] adjacentMatrix = new int[numCourses][numCourses];
        // int[] inDegree = new int[numCourses];
        // int[] result = new int[numCourses];
        // int course;
        // int count = 0;
        // for (int i = 0; i < prerequisites.length; i++) {
        //     int pre = prerequisites[i][1];
        //     int late = prerequisites[i][0];
        //     if (adjacentMatrix[pre][late] == 0) {
        //         inDegree[late]++;
        //     }
        //     adjacentMatrix[pre][late] = 1;
        // }

        // Queue<Integer> temp = new LinkedList<>();
        // for (int i = 0; i < inDegree.length; i++) {
        //     if (inDegree[i] == 0) {
        //         temp.offer(i);
        //     }
        // }

        // while (!temp.isEmpty()) {
        //     course = temp.poll();
        //     result[count] = course;
        //     count++;
        //     for (int i = 0; i < numCourses; i++) {
        //         if (adjacentMatrix[course][i] == 1) {
        //             inDegree[i]--;
        //             if (inDegree[i] == 0) {
        //                 temp.offer(i);
        //             }
        //         }
        //     }
        // }

        // if (count == numCourses) {
        //     return result;
        // } else {
        //     return new int[] {};
        // }

        // DFS
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            map.putIfAbsent(child, new HashSet<>());
            map.get(child).add(parent);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(map, visited, i, res)) {
                return new int[0];
            }
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
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

