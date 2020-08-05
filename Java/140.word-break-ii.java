import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    Map<String, List<String>> dp = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, s.length(), wordDict);
    }

    private List<String> dfs(String s, int end, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || end == 0) {
            return result;
        }
        String string = s.substring(0, end);
        if (dp.containsKey(string)) {
            return dp.get(string);
        }
        if (wordDict.contains(string)) {
            result.add(string);
        }
        for (int i = 1; i < string.length(); i++) {
            String temp = string.substring(i);
            if (wordDict.contains(temp)) {
                List<String> words = dfs(s, i, wordDict);
                for (String word : words) {
                    result.add(word + " " + temp);
                }
            }
        }
        dp.put(string, result);
        System.out.println(dp);
        return result;
    }
}
// @lc code=end

