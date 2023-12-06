/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = num1.length() - 1, p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int val1 = 0, val2 = 0;
            if (p1 >= 0) {
                val1 = num1.charAt(p1--) - '0';
            }
            if (p2 >= 0) {
                val2 = num2.charAt(p2--) - '0';
            }
            carry += val1 + val2;
            sb.append(carry % 10);
            carry /= 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

