/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        // int[][] dummy = new int[board.length][board[0].length];
        // for (int i = 0; i < dummy.length; i++) {
        //     for (int j = 0; j < dummy[0].length; j++) {
        //         dummy[i][j] = board[i][j];
        //     }
        // }
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[0].length; j++) {
        //         int live = countLive(dummy, i, j);
        //         if (dummy[i][j] == 1) {
        //             if (live != 2 && live != 3) {
        //                 board[i][j] = 0;
        //             }
        //         } else {
        //             if (live == 3) {
        //                 board[i][j] = 1;
        //             }
        //         }
        //     }
        // }

        // In-place
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = countLive(board, i, j);
                if (board[i][j] == 1 && (live == 2 || live == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countLive(int[][] board, int x, int y) {
        int count = 0;
        int[][] around = new int[][] {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] change : around) {
            int i = x + change[0];
            int j = y + change[1];
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                count += board[i][j] & 1;
            }
        }
        return count;
    }
}
// @lc code=end

