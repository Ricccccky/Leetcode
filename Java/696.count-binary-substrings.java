/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        // int n = s.length();
        // int res = 0;
        // int ptr = 0;
        // int[] groups = new int[n];
        // groups[0] = 1;
        // for (int i = 1; i < n; i++) {
        //     if (s.charAt(i) == s.charAt(i - 1)) {
        //         groups[ptr]++;
        //     } else {
        //         groups[++ptr] = 1;
        //     }
        // }
        // for (int i = 1; i <= ptr; i++) {
        //     res += Math.min(groups[i], groups[i - 1]);
        // }

        // return res;

        int len = 1;
        int prev = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                res += Math.min(prev, len);
                prev = len;
                len = 1;
            }
        }
        res += Math.min(prev, len);

        return res;
    }
}
// @lc code=end

