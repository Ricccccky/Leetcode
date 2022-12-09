/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        while (p2 < s.length()) {
            if (s.charAt(p2) == ' ') {
                p1 = 0;
                p2++;
                continue;
            }
            if (p1 == 0) {
                sb.insert(p1, " ");
                p1++;
            }
            sb.insert(p1, s.charAt(p2));
            p1++;
            p2++;
        }

        return sb.toString().trim();
    }
}
// @lc code=end

