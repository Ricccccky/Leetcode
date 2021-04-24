import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=488 lang=java
 *
 * [488] Zuma Game
 */

// @lc code=start
class Solution {
    public int findMinStep(String board, String hand) {
        Map<String, Integer> memo = new HashMap<>();
        int[] balls = new int[26];
        int res = 0;
        for (char c : hand.toCharArray()) {
            balls[c - 'A']++;
        }
        memo.put("", 0);
        res = dfs(board, balls, memo);

        return res > 5 ? -1 : res;
    }

    private int dfs(String board, int[] balls, Map<String, Integer> memo) {
        char[] hand = new char[] {'B', 'G', 'R', 'W', 'Y'};
        int res = 6;
        board = removeDuplicate(board);
        if (memo.containsKey(board)) {
            return memo.get(board);
        }
        for (int i = 0; i < board.length(); i++) {
            for (char c : hand) {
                if (balls[c - 'A'] > 0) {
                    balls[c - 'A']--;
                    StringBuilder sb = new StringBuilder(board);
                    sb.insert(i, c);
                    res = Math.min(res, 1 + dfs(sb.toString(), balls, memo));
                    balls[c - 'A']++;
                }
            }
        }
        memo.put(board, res);

        return res;
    }

    private String removeDuplicate(String s) {
        int i, j;
        for (i = 0, j = 0; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                continue;
            }
            if (j - i >= 3) {
                return removeDuplicate(s.substring(0, i) + s.substring(j));
            }
            i = j;
        }
        if (j - i >= 3) {
            return s.substring(0, i);
        }

        return s;
    }
}
// @lc code=end

