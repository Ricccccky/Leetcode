/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!cnt.containsKey(c) || cnt.get(c) == 0) {
                return false;
            }
            cnt.put(c, cnt.get(c) - 1);
        }

        return true;
    }
}
// @lc code=end

