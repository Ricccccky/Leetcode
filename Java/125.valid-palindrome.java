/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        int l = 0, r = s.length() - 1;
        char[] x = s.toCharArray();

        while(l < r) {
            if (Character.toLowerCase(x[l]) == Character.toLowerCase(x[r])) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

