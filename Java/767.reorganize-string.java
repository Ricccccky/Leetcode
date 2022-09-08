
/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int n = s.length();
        int max = 0, ptr = 0, maxChar = 0;
        char[] arr = new char[n];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (max < freq[c - 'a']) {
                max = freq[c - 'a'];
                maxChar = c - 'a';
            }
        }
        if (max > (n + 1) / 2) {
            return "";
        }
        while (freq[maxChar] > 0) {
            arr[ptr] = (char)(maxChar + 'a');
            freq[maxChar]--;
            ptr += 2;
        }
        for (int i = 0; i < freq.length; i++) {
            while (freq[i]-- > 0) {
                if (ptr >= n) {
                    ptr = 1;
                }
                arr[ptr] = (char)(i + 'a');
                ptr += 2;
            }
        }

        return String.valueOf(arr);
    }
}
// @lc code=end

