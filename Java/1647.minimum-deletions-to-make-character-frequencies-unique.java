import java.util.*;

/*
 * @lc app=leetcode id=1647 lang=java
 *
 * [1647] Minimum Deletions to Make Character Frequencies Unique
 */

// @lc code=start
class Solution {
    public int minDeletions(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        int result = 0, max = s.length();
        for (char c : arr) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        for (int i = 25; i >= 0 && count[i] > 0; i--) {
            if (count[i] > max) {
                result += count[i] - max;
                count[i] = max;
            }
            max = Math.max(count[i] - 1, 0);
        }

        return result;
    }
}
// @lc code=end

