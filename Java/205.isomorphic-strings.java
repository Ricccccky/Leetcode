/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sMap[sc] != tMap[tc]) {
                return false;
            }
            sMap[sc] = i + 1;
            tMap[tc] = i + 1;
        }

        return true;
    }
}
// @lc code=end

