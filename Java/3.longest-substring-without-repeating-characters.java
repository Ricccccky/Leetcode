import java.util.*;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> temp = new HashMap<>();
        int p1 = 0, p2 = 0;
        int result = 0;
        while(p2 < s.length()) {
            if (temp.containsKey(s.charAt(p2))) {
                p1 = Math.max(temp.get(s.charAt(p2)) + 1, p1);
            }
            temp.put(s.charAt(p2), p2);
            p2++;
            result = Math.max(p2 - p1, result);
        }
        
        return result;
    }
}
// @lc code=end

