/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0, curSum = 0;
        int result = 0;
        int l = 0, r = 0;
        for (int card : cardPoints) {
            totalSum += card;
        }
        if (k == n) {
            return totalSum;
        }
        while (r < n) {
            curSum += cardPoints[r++];
            if (r - l == n - k) {
                result = Math.max(totalSum - curSum, result);
                curSum -= cardPoints[l++];
            }
        }

        return result;
    }
}
// @lc code=end

