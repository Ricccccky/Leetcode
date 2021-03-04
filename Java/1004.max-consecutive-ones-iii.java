/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] A, int K) {
        int ptr = 0, i;
        for (i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                K--;
            }
            if (K < 0 && A[ptr++] == 0) {
                K++;
            }
        }

        return i - ptr;
    }
}
// @lc code=end

