/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String target = "123450";
        int res = 0;
        int[][] dirs = new int[][] {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        if (sb.toString().equals(target)) {
            return 0;
        }
        queue.add(sb.toString());
        set.add(sb.toString());
        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;
            while (len-- > 0) {
                String cur = queue.poll();
                sb = new StringBuilder(cur);
                int pos = sb.indexOf("0");
                for (int dir : dirs[pos]) {
                    sb = new StringBuilder(cur);
                    sb.setCharAt(pos, sb.charAt(dir));
                    sb.setCharAt(dir, '0');
                    if (set.contains(sb.toString())) {
                        continue;
                    }
                    if (sb.toString().equals(target)) {
                        return res;
                    }
                    set.add(sb.toString());
                    queue.offer(sb.toString());
                }
            }
        }
        
        return -1;
    }
}
// @lc code=end

