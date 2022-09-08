import java.util.*;

/*
 * @lc app=leetcode id=1044 lang=java
 *
 * [1044] Longest Duplicate Substring
 */

// @lc code=start
class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int l = 1, r = n;
        while (l <= r) {
            int len = l + (r - l) / 2;
            if (binarySearch(s, len, n) != -1) {
                l = len + 1;
            } else {
                r = len - 1;
            }
        }
        if (l - 1 == 0) {
            return "";
        }
        int start = binarySearch(s, l - 1, n);
        return s.substring(start, start + l - 1);
    }
    
    private int binarySearch(String s, int L, int n) {
        int R = 26;
        long mod = 1000000007;
        long RL = 1;
        int l = 0, r = 0;
        long windowHash = 0;
        Map<Long, List<Integer>> visited = new HashMap<>();
        for (int i = 1; i < L; i++) {
            RL = (RL * R) % mod;
        }
        while (r < n) {
            windowHash = ((R * windowHash) % mod + s.charAt(r) - 'a') % mod;
            r++;
            if (r - l == L) {
                List<Integer> hits = visited.get(windowHash);
                if (hits != null) {
                    String cur = s.substring(l, l + L);
                    for (int i : hits) {
                        String candiate = s.substring(i, i + L);
                        if (candiate.equals(cur)) {
                            return i;
                        }
                    }
                }
                visited.putIfAbsent(windowHash, new ArrayList<>());
                visited.get(windowHash).add(l);
                windowHash = (windowHash - ((s.charAt(l) - 'a') * RL) % mod + mod) % mod;
                l++;
            }
        }

        return -1;
    }
}
// @lc code=end

