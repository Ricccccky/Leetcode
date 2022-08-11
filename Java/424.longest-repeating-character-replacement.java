
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
        int n = s.length();
        char[] sArray = s.toCharArray();
        while (tail < n) {
            int c = sArray[tail] - 'A';
            counter[c]++;
            maxFreq = Math.max(maxFreq, counter[c]);
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

