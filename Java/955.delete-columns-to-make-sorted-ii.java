/*
 * @lc app=leetcode id=955 lang=java
 *
 * [955] Delete Columns to Make Sorted II
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] A) {
        int numRow = A.length;
        int numCol = A[0].length();
        int result = 0;
        boolean[] temp = new boolean[numRow];
        for (int i = 0; i < numCol; i++) {
            int j;
            for (j = 0; j < numRow - 1; j++) {
                if (!temp[j] && A[j].charAt(i) > A[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
            if (j >= numRow - 1) {
                for (j = 0; j < numRow - 1; j++) {
                    temp[j] |= A[j].charAt(i) < A[j + 1].charAt(i);
                }
            }
        }
        return result;
    }
}
// @lc code=end

