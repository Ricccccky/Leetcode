/*
 * @lc app=leetcode id=1347 lang=java
 *
 * [1347] Minimum Number of Steps to Make Two Strings Anagram
 */

// @lc code=start
class Solution {
    public int minSteps(String s, String t) {
        int res = 0;
        int n = s.length();
        int[] count = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < n; i++) {
            count[sArr[i] - 'a']++;
            count[tArr[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            res += Math.max(0, count[i]);
        }

        return res;
    }
}
// @lc code=end

