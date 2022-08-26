import java.util.*;

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
                if (board[i][j] != 0 && live >=2 && live < 4) {
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
        List<int[]> around = new ArrayList<>();
        around.add(new int[] {1, 1});
        around.add(new int[] {1, -1});
        around.add(new int[] {-1, 1});
        around.add(new int[] {-1, -1});
        around.add(new int[] {0, 1});
        around.add(new int[] {0, -1});
        around.add(new int[] {1, 0});
        around.add(new int[] {-1, 0});
        for (int[] change : around) {
            if (x + change[0] >= 0 && x + change[0] < board.length && y + change[1] >= 0 && y + change[1] < board[0].length) {
                count += board[x + change[0]][y + change[1]] & 1;
            }
        }
        return count;
    }
}
// @lc code=end

