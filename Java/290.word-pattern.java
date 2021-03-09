import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Object, Integer> map = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (Integer i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            map.putIfAbsent(c, i);
            map.putIfAbsent(words[i], i);
            if (map.get(c) != map.get(words[i])) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

