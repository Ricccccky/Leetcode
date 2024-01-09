/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length(), carry = 0;
        int[] prods = new int[m + n];
        StringBuilder sb = new StringBuilder();
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0', y = num2.charAt(j) - '0';
                prods[i + j + 1] += x * y;
            }
        }
        for (int i = prods.length - 1; i >= 0; i--) {
            int digit = (carry + prods[i]) % 10;
            carry = (carry + prods[i]) / 10;
            prods[i] = digit;
        }
        for (int digit : prods) {
            sb.append(digit);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

