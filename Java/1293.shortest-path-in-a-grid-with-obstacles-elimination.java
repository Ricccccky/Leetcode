import java.util.*;

/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 */

// @lc code=start
class Solution {
    private final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    class State {
        public int r;
        public int c;
        public int steps;
        public int k;

        public State(int r, int c, int steps, int k) {
            this.r = r;
            this.c = c;
            this.steps = steps;
            this.k = k;
        }

        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return (r + 1) * (c + 1) * k;
        }

        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            State state = (State) obj;
            return this.r == state.r && this.c == state.c && this.k == state.k;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return r + "," + c + "," + steps + "," + k;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (k >= m + n - 2) {
            return m + n - 2;
        }
        Deque<State> queue = new LinkedList<>();
        Set<State> set = new HashSet<>();
        State cur = new State(0, 0, 0, k);
        queue.offer(cur);
        set.add(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.r == m - 1 && cur.c == n - 1) {
                return cur.steps;
            }
            for (int[] dir : dirs) {
                int r = cur.r+ dir[0];
                int c = cur.c + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    State next = new State(r, c, cur.steps + 1, cur.k - grid[r][c]);
                    if (next.k >= 0 && !set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    } 
                }
            }
        }
        
        return -1;
    }
}
// @lc code=end

