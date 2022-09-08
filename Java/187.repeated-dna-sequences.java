import java.util.*;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Rabin-Karp
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>();
        int L = 10, R = 4;
        int RL = (int) Math.pow(R, L - 1);
        int windowHash = 0;
        int l = 0, r = 0;
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        while (r < s.length()) {
            char c = s.charAt(r++);
            windowHash = R * windowHash + map.get(c);
            if (r - l == L) {
                if (seen.contains(windowHash)) {
                    result.add(s.substring(l, r));
                } else {
                    seen.add(windowHash);
                }
                windowHash = windowHash - map.get(s.charAt(l++)) * RL;
            }
        }

        return new ArrayList<>(result);
    }
}
// @lc code=end

