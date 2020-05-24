import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        String result = "";
        int min = s.length() + 1;
        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), 0);
        }

        int head = 0, tail = 0;
        int len = 0;
        while (tail < s.length()) {
            if (tMap.containsKey(s.charAt(tail))) {
                if (sMap.get(s.charAt(tail)) < tMap.get(s.charAt(tail))) {
                    len++;
                }
                sMap.put(s.charAt(tail), sMap.get(s.charAt(tail)) + 1);
            }

            if (len == t.length()) {
                while (!tMap.containsKey(s.charAt(head)) || sMap.get(s.charAt(head)) > tMap.get(s.charAt(head))) {
                    if (tMap.containsKey(s.charAt(head))) {
                        sMap.put(s.charAt(head), sMap.get(s.charAt(head)) - 1);
                    }
                    head++;
                }
                if (tail - head + 1 < min) {
                    result = s.substring(head, tail + 1);
                    min = tail - head + 1;
                }
            }
            tail++;
        }
        return result;
    }
}
// @lc code=end

