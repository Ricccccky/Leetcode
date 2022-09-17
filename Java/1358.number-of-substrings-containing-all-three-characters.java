/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int result = 0;
        int n = s.length(), i = 0;
        for (int j = 0; j < n; j++) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(i++) - 'a']--;
            }
            result += i;
        }

        return result;
    }
}
// @lc code=end

