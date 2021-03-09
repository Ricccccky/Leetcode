import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=291 lang=java
 *
 * [291] Word Pattern II
 */

// @lc code=start
class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        List<String> list = new ArrayList<>();
        return backtracking(pattern, s, list, 0);
    }

    private boolean backtracking(String pattern, String s, List<String> list, int idx) {
        if (list.size() == pattern.length() && idx == s.length()) {
            return patternMatch(pattern, list);
        } else if (list.size() < pattern.length() && idx < s.length()) {
            for (int i = idx + 1; i <= s.length(); i++) {
                String word = s.substring(idx, i);
                list.add(word);
                if (backtracking(pattern, s, list, i)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }

        return false;
    }

    private boolean patternMatch(String pattern, List<String> list) {
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            map.putIfAbsent(c, i);
            map.putIfAbsent(list.get(i), i);
            if (map.get(c) != map.get(list.get(i))) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

