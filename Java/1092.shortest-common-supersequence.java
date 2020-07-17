import java.util.Arrays;

/*
 * @lc app=leetcode id=1092 lang=java
 *
 * [1092] Shortest Common Supersequence 
 */

// @lc code=start
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String LCS = longestCommonSubsquence(str1, str2);
        StringBuilder result = new StringBuilder();
        int p1 = 0, p2 = 0;
        for (int i = 0; i < LCS.length(); i++) {
            while (p1 < str1.length() && str1.charAt(p1) != LCS.charAt(i)) {
                result.append(str1.charAt(p1));
                p1++;
            }
            while (p2 < str2.length() && str2.charAt(p2) != LCS.charAt(i)) {
                result.append(str2.charAt(p2));
                p2++;
            }
            result.append(LCS.charAt(i));
            p1++;
            p2++;
        }
        result.append(str1.substring(p1));
        result.append(str2.substring(p2));
        return result.toString();
    }

    private String longestCommonSubsquence(String str1, String str2) {
        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
// @lc code=end

