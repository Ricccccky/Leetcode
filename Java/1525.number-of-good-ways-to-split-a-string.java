import java.util.*;

/*
 * @lc app=leetcode id=1525 lang=java
 *
 * [1525] Number of Good Ways to Split a String
 */

// @lc code=start
class Solution {
    public int numSplits(String s) {
        int result = 0;
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        for (Character c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        for (Character c : s.toCharArray()) {
            left.put(c, left.getOrDefault(c, 0) + 1);
            right.put(c, right.get(c) - 1);
            if (right.get(c) == 0) {
                right.remove(c);
            }
            if (left.size() == right.size()) {
                result++;
            }
        }

        return result;
    }
}
// @lc code=end

