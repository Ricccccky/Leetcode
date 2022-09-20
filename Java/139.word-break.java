import java.util.*;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    private class Trie {
        boolean isWord;
        Trie[] child;

        public Trie() {
            isWord = false;
            child = new Trie[26];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (String word : wordDict) {
            Trie dummy = root;
            for (char c : word.toCharArray()) {
                if (dummy.child[c - 'a'] == null) {
                    dummy.child[c - 'a'] = new Trie();
                }
                dummy = dummy.child[c - 'a'];
            }
            dummy.isWord = true;
        }
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            Trie dummy = root;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (dummy.child[c - 'a'] == null) {
                    break;
                }
                dummy = dummy.child[c - 'a'];
                if (dummy.isWord && dp[i]) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }
}
// @lc code=end

