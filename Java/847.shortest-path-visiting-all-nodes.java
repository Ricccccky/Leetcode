import java.util.*;

/*
 * @lc app=leetcode id=847 lang=java
 *
 * [847] Shortest Path Visiting All Nodes
 */

// @lc code=start
class Solution {
    class Node {
        int mask;
        int val;

        public Node (int mask, int val) {
            this.mask = mask;
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " " + mask;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int res = 0;
        int target = (1 << graph.length) - 1;
        Queue<Node> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            Node node = new Node(1 << i, i);
            queue.offer(node);
            set.add(node.toString());
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                Node cur = queue.poll();
                if (cur.mask == target) {
                    return res;
                }
                for (int neighbor : graph[cur.val]) {
                    Node next = new Node(cur.mask | (1 << neighbor), neighbor);
                    if (set.contains(next.toString())) {
                        continue;
                    }
                    set.add(next.toString());
                    queue.offer(next);
                }
            }
            res++;
        }

        return res;
    }
}
// @lc code=end

