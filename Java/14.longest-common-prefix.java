/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // find the shortest str
            if (strs[i].length() < result.length()) {
                result = strs[i];
            }
        }
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }
        
        return result;
    }
}
// @lc code=end

