/*
 * @lc app=leetcode id=2193 lang=java
 *
 * [2193] Minimum Number of Moves to Make Palindrome
 */

// @lc code=start
class Solution {
    public int minMovesToMakePalindrome(String s) {
        int result = 0;
        while (s.length() > 0) {
            int index = s.indexOf(s.charAt(s.length() - 1));
            if (index == s.length() - 1) {
                result += index / 2;
            } else {
                result += index;
                s = s.substring(0, index) + s.substring(index + 1);
            }
            s = s.substring(0, s.length() - 1);
        }

        return result;
    }
}
// @lc code=end

