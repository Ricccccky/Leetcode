/*
 * @lc app=leetcode id=246 lang=java
 *
 * [246] Strobogrammatic Number
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length(), l = 0, r = n - 1;
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        while (l <= r) {
            char p = num.charAt(l), q = num.charAt(r);
            if (map.containsKey(p) && map.get(p) == q) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

