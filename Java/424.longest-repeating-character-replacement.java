import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        int head = 0, tail = 0;
        int maxFreq = 0;
        int result = 0;
        char[] sArray = s.toCharArray();
        while (tail < s.length()) {
            counter[sArray[tail] - 'A']++;
            maxFreq = Math.max(maxFreq, counter[sArray[tail] - 'A']);
            while (tail - head + 1 - maxFreq > k) {
                counter[sArray[head] - 'A']--;
                head++;
            }
            result = Math.max(result, tail - head + 1);
            tail++;
        }
        return result;

    }
}
// @lc code=end

