/*
 * @lc app=leetcode id=1395 lang=java
 *
 * [1395] Count Number of Teams
 */

// @lc code=start
class Solution {
    public int numTeams(int[] rating) {
        int result = 0;
        int n = rating.length;
        for (int i = 1; i < n - 1; i++) {
            int leftSmall = 0, leftLarge = 0;
            int rightSmall = 0, rightLarge = 0;
            for (int j = 0; j < n; j++) {
                if (rating[i] < rating[j]) {
                    if (i > j) {
                        leftLarge++;
                    } else {
                        rightLarge++;
                    }
                }
                if (rating[i] > rating[j]) {
                    if (i > j) {
                        leftSmall++;
                    } else {
                        rightSmall++;
                    }
                }
            }
            result += leftLarge * rightSmall + rightLarge * leftSmall;
        }

        return result;
    }
}
// @lc code=end

