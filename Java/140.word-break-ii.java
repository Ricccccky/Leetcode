import java.util.*;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, s.length(), wordDict, new HashMap<>());
    }

    private List<String> dfs(String s, int end, List<String> wordDict, Map<String, List<String>> dp) {
        List<String> result = new ArrayList<>();
        String prefix = s.substring(0, end);
        if (dp.containsKey(prefix)) {
            return dp.get(prefix);
        }
        if (wordDict.contains(prefix)) {
            result.add(prefix);
        }
        for (int i = prefix.length() - 1; i >= 0; i--) {
            String suffix = prefix.substring(i);
            if (wordDict.contains(suffix)) {
                List<String> temp = dfs(s, i, wordDict, dp);
                for (String words : temp) {
                    result.add(words + " " + suffix);
                }
            }
        }
        dp.put(prefix, result);

        return result;
    }
}
// @lc code=end

