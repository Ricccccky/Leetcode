/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, m = word1.length(), n = word2.length();
        while (i < m && j < n) {
            sb.append(word1.charAt(i++))
            .append(word2.charAt(j++));
        }
        while (i < m) {
            sb.append(word1.charAt(i++));
        }
        while (j < n) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}
// @lc code=end

