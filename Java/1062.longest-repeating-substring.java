import java.util.*;

/*
 * @lc app=leetcode id=1062 lang=java
 *
 * [1062] Longest Repeating Substring
 */

// @lc code=start
class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int l = 1, r = n;
        while (l <= r) {
            int len = l + (r - l) / 2;
            if (binarySearch(s, len, n) > 0) {
                l = len + 1;
            } else {
                r = len - 1;
            }
        }

        return l - 1;
    }

    private int binarySearch(String s, int L, int n) {
        int R = 26;
        long mod = 1000000007;
        long RL = 1;
        int l = 0, r = 0;
        long windowHash = 0;
        Set<Long> visited = new HashSet<>();
        for (int i = 1; i < L; i++) {
            RL = (RL * R) % mod;
        }
        while (r < n) {
            windowHash = ((R * windowHash) % mod + s.charAt(r) - 'a') % mod;
            r++;
            if (r - l == L) {
                if (visited.contains(windowHash)) {
                    return l;
                }
                visited.add(windowHash);
                windowHash = (windowHash - ((s.charAt(l) - 'a') * RL) % mod + mod) % mod;
                l++;
            }
        }

        return -1;
    }
}
// @lc code=end

