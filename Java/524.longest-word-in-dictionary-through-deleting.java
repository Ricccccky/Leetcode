/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String d : dictionary) {
            if (res.length() > d.length() || (res.length() == d.length() && res.compareTo(d) < 0)) {
                continue;
            }
            if (isSubString(s, d)) {
                res = d;
            }
        }

        return res;
    }

    private boolean isSubString(String s, String d) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < d.length()) {
            if (s.charAt(i) == d.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == d.length();
    }
}
// @lc code=end

