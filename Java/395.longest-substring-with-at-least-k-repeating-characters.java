import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            set.add(c);
        }
        int unique = set.size();
        for (int i = 1; i <= unique; i++) {
            Arrays.fill(count, 0);
            int start = 0, end = 0, occur = 0, countK = 0;
            while (end < s.length()) {
                if (occur <= i) {
                    int idx = arr[end] - 'a';
                    if (count[idx] == 0) {
                        occur++;
                    }
                    count[idx]++;
                    if (count[idx] == k) {
                        countK++;
                    }
                    end++;
                } else {
                    int idx = arr[start] - 'a';
                    if (count[idx] == k) {
                        countK--;
                    }
                    count[idx]--;
                    if (count[idx] == 0) {
                        occur--;
                    }
                    start++;
                }
                if (occur == i && countK == occur) {
                    res = Math.max(res, end - start);
                }
            }
        }

        return res;
    }
}
// @lc code=end

