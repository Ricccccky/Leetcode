/*
 * @lc app=leetcode id=2011 lang=java
 *
 * [2011] Final Value of Variable After Performing Operations
 */

// @lc code=start
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String o : operations) {
            if (o.charAt(0) == '+' || o.charAt(2) == '+') {
                X++;
            } else {
                X--;
            }
        }

        return X;
    }
}
// @lc code=end

