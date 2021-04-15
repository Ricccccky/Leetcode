/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i, j - 1) || validPalindrome(s, i + 1, j);
            }
        }

        return true;
    }

    private boolean validPalindrome(String s, int start, int end) {
        while (start <= end) {
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

