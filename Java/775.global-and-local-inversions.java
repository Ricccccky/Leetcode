/*
 * @lc app=leetcode id=775 lang=java
 *
 * [775] Global and Local Inversions
 */

// @lc code=start
class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        int max = A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] < max) {
                return false;
            }
            max = Math.max(max, A[i - 1]);
        }
        return true;
    }
}
// @lc code=end

