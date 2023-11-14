/*
 * @lc app=leetcode id=2405 lang=java
 *
 * [2405] Optimal Partition of String
 */

// @lc code=start

import java.util.*;

class Solution {
    public int partitionString(String s) {
        int res = 1, start = 0, n = s.length();
        int[] prev = new int[26];
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (prev[c - 'a'] >= start) {
                start = i;
                res++;
            }
            prev[c - 'a'] = i;
        }

        return res;
    }
}
// @lc code=end

