/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int len = 0;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0) {
                count++;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (count1[c - 'a'] != 0) {
                count2[c - 'a']++;
                if (count2[c - 'a'] == count1[c - 'a']) {
                    len++;
                }

            }
            if (i >= s1.length()) {
                c = s2.charAt(i - s1.length());
                if (count1[c - 'a'] != 0) {
                    if (count1[c - 'a'] == count2[c - 'a']) {
                        len--;
                    }
                    count2[c - 'a']--;
                }
            }
            if (len == count) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

