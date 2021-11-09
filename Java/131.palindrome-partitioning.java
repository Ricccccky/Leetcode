import java.util.*;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        // for (int i = s.length() - 1; i >= 0; i--) {
        //     for (int j = s.length() - 1; j >= i; j--) {
        //         if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
        //             dp[i][j] = true;
        //         }
        //     }
        // }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        backtracking(res, s, dp, 0, new ArrayList<>());
        
        return res;
    }
    
    private void backtracking(List<List<String>> res, String s, boolean[][] dp, int pos, List<String> tmp) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                tmp.add(s.substring(pos, i + 1));
                backtracking(res, s, dp, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
// @lc code=end

