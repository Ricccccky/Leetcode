/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            return addBinary(b, a);
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            if (carry % 2 == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            carry /= 2;
        }
        if (carry == 1) {
            sb.append('1');
        }
        sb.reverse();
        
        return sb.toString();
    }
}
// @lc code=end

