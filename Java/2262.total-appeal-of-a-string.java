
/*
 * @lc app=leetcode id=2262 lang=java
 *
 * [2262] Total Appeal of A String
 */

// @lc code=start
class Solution {
    public long appealSum(String s) {
        long result = 0;
        long cur = 0;
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cur -= last[c - 'a'];
            last[c - 'a'] = i + 1;
            cur += last[c - 'a'];
            result += cur;
        }

        return result;
    }
}
// @lc code=end

