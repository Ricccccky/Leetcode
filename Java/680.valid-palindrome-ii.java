/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i, j - 1) || validPalindrome(s, i + 1, j);
            }
        }

        return true;
    }

    public boolean validPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
// @lc code=end

