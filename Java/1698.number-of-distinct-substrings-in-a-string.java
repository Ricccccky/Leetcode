import java.util.*;

/*
 * @lc app=leetcode id=1698 lang=java
 *
 * [1698] Number of Distinct Substrings in a String
 */

// @lc code=start
class Solution {
    private class Trie {
        Trie[] child;

        public Trie() {
            child = new Trie[26];
        }
    }
    public int countDistinct(String s) {
        int result = 0;
        Trie root = new Trie();
        for (int i = 0; i < s.length(); i++) {
            Trie dummy = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (dummy.child[c - 'a'] == null) {
                    dummy.child[c - 'a'] = new Trie();
                    result++;
                }
                dummy = dummy.child[c - 'a'];
            }
        }

        return result;
    }
}
// @lc code=end

