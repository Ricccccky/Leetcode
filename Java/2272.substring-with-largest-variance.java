import java.util.*;

/*
 * @lc app=leetcode id=2272 lang=java
 *
 * [2272] Substring With Largest Variance
 */

// @lc code=start
class Solution {
    public int largestVariance(String s) {
        int result = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char maxChar : freq.keySet()) {
            for (char minChar : freq.keySet()) {
                if (maxChar == minChar) {
                    continue;
                }
                int minCount = 0;
                int maxCount = 0;
                int remainMin = freq.get(minChar);
                for (int i = 0; i < s.length(); i++) {
                    char cur = s.charAt(i);
                    if (cur == maxChar) {
                        maxCount++;
                    }
                    if (cur == minChar) {
                        minCount++;
                        remainMin--;
                    }
                    if (maxCount > 0 && minCount > 0 && maxCount > minCount) {
                        result = Math.max(result, maxCount - minCount);
                    }
                    if (maxCount < minCount && remainMin > 0) {
                        maxCount = 0;
                        minCount = 0;
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

