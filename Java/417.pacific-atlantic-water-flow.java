/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visitedP = new boolean[row][col];
        boolean[][] visitedA = new boolean[row][col];
        Deque<int[]> queueP = new LinkedList<>();
        Deque<int[]> queueA = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            visitedP[i][0] = true;
            visitedA[i][col - 1] = true;
            queueP.add(new int[] {i, 0});
            queueA.add(new int[] {i, col - 1});
        }
        
        for (int i = 0; i < col; i++) {
            visitedP[0][i] = true;
            visitedA[row - 1][i] = true;
            queueP.add(new int[] {0, i});
            queueA.add(new int[] {row - 1, i});
        }
        
        bfs(matrix, visitedP, queueP);
        bfs(matrix, visitedA, queueA);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visitedP[i][j] && visitedA[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }
    
    private void bfs(int[][] matrix, boolean[][] visited, Deque<int[]> queue) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] >= matrix[cur[0]][cur[1]]) {
                    visited[x][y] = true;
                    queue.add(new int[] {x, y});
                }
            }
        }
    }
}
// @lc code=end

