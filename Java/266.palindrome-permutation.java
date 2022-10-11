/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 */

// @lc code=start
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[26];
        int odd = 0;
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i : freq) {
            if (i % 2 == 1) {
                odd++;
            }
        }

        return odd <= 1;
    }
}
// @lc code=end

