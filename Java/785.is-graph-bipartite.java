import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int top = queue.poll();
                for (int node : graph[top]) {
                    if (color[node] == 0) {
                        color[node] = -color[top];
                        queue.offer(node);
                    } else if (color[node] == color[top]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

