/*
 * @lc app=leetcode id=896 lang=java
 *
 * [896] Monotonic Array
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        if (A[0] < A[A.length - 1]) {
            for (int i = 1; i < A.length; i++) {
                if (A[i] < A[i - 1]) {
                    return false;
                }
            }
        } else if (A[0] > A[A.length - 1]) {
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < A.length; i++) {
                if (A[i] != A[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

