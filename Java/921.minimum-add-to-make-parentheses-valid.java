/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0, left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left <= 0) {
                    res++;
                } else {
                    left--;
                }
            }
        }
        res += left;
                
        return res;
    }
}
// @lc code=end

