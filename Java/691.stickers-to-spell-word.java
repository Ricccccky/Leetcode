/*
 * @lc app=leetcode id=691 lang=java
 *
 * [691] Stickers to Spell Word
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minStickers(String[] stickers, String target) {
        Map<String, Integer> dp = new HashMap<>();
        int n = stickers.length;
        int[][] counters = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                counters[i][c - 'a']++;
            }
        }
        dp.put("", 0);

        return helper(dp, counters, target);
    }

    private int helper(Map<String, Integer> dp, int[][] counters, String target) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int n = counters.length, res = 20;
        int[] cnt = new int[26];
        for (char c : target.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (counters[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (cnt[j] > 0) {
                    for (int k = 0; k < Math.max(0, cnt[j] - counters[i][j]); k++) {
                        sb.append((char)(j + 'a'));
                    }
                }
            }
            int temp = helper(dp, counters, sb.toString());
            if (temp != -1) {
                res = Math.min(res, temp + 1);
            }
        }
        dp.put(target, res == 20 ? -1 : res);
        return dp.get(target);
    }
}
// @lc code=end

