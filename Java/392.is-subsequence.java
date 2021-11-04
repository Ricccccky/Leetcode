/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        // Two pointer
        // int i = 0;
        // int j = 0;
        // while (i < s.length() && j < t.length()) {
        //     if (s.charAt(i) == t.charAt(j)) {
        //         i++;
        //     }
        //     j++;
        // }
        
        // return i == s.length();

        // Greedy
        int ptr = -1;
        for (char c : s.toCharArray()) {
            ptr = t.indexOf(c, ptr + 1);
            if (ptr == -1) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

