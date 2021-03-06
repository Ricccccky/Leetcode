/*
 * @lc app=leetcode id=828 lang=java
 *
 * [828] Count Unique Characters of All Substrings of a Given String
 */

// @lc code=start
class Solution {
    public int uniqueLetterString(String s) {
        int mod = 1000000007;
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        int[] lastIdx = new int[26];
        int[] nums = new int[26];
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cur -= nums[c - 'A'];
            nums[c - 'A'] = i - lastIdx[c - 'A'] + 1;
            cur += nums[c - 'A'] ;
            cur %= mod;
            lastIdx[c - 'A'] = i + 1;
            res += cur;
            res %= mod;
        }

        return res;
    }
}
// @lc code=end

