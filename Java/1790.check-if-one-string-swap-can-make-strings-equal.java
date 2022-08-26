/*
 * @lc app=leetcode id=1790 lang=java
 *
 * [1790] Check if One String Swap Can Make Strings Equal
 */

// @lc code=start
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        int ptr = 0;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                index[ptr++] = i;
            }
        }
        if (ptr != 2) {
            return false;
        }
        if (s1.charAt(index[0]) == s2.charAt(index[1]) && s1.charAt(index[1]) == s2.charAt(index[0])) {
            return true;
        }

        return false;
    }
}
// @lc code=end

