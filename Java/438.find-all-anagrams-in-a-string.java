import java.util.*;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int start = 0, end = 0;
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> result = new ArrayList<>();
        if (sLen < pLen) {
            return result;
        }
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        while (end < sLen) {
            char c = s.charAt(end++);
            sCount[c - 'a']++;
            if (end - start == pLen) {
                if (Arrays.equals(sCount, pCount)) {
                    result.add(start);
                }
                c = s.charAt(start++);
                sCount[c - 'a']--;
            }
        }

        return result;
    }
}
// @lc code=end

