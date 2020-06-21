/*
 * @lc app=leetcode id=832 lang=java
 *
 * [832] Flipping an Image
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length / 2 + A.length % 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A.length - j - 1] ^ 1;
                A[i][A.length - j - 1] = temp ^ 1;
            }
        }
        return A;
    }
}
// @lc code=end

