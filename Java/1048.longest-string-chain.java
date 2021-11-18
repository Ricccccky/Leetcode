import java.util.*;

/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        int res = 0;
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                count = Math.max(count, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, count);
            res = Math.max(res, count);
        }

        return res;
    }
}
// @lc code=end

