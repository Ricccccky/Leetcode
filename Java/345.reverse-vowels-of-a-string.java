import java.util.*;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (i <= j) {
            char x = sb.charAt(i);
            char y = sb.charAt(j);
            if (set.contains(x) && set.contains(y)) {
                sb.setCharAt(i, y);
                sb.setCharAt(j, x);
                i++;
                j--;
            } else if (set.contains(x)) {
                j--;
            } else if (set.contains(y)) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return sb.toString();
    }
}
// @lc code=end

