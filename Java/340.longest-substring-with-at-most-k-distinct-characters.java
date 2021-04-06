import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // O(n)
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int p1 = 0, p2 = 0; p2 < s.length(); p2++) {
            char c = s.charAt(p2);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char head = s.charAt(p1);
                map.put(head, map.get(head) - 1);
                p1++;
                if (map.get(head) == 0) {
                    map.remove(head);
                }
            }
            res = Math.max(res, p2 - p1 + 1);
        }

        return res;
    }
}
// @lc code=end

