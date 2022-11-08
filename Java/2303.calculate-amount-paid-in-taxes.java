/*
 * @lc app=leetcode id=2303 lang=java
 *
 * [2303] Calculate Amount Paid in Taxes
 */

// @lc code=start
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0;
        int prev = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income > brackets[i][0]) {
                result += (double)brackets[i][1] / 100 * (brackets[i][0] - prev);
            } else {
                result += (double)brackets[i][1] / 100 * (income - prev);
                break;
            }
            prev = brackets[i][0];
        }

        return result;
    }
}
// @lc code=end

