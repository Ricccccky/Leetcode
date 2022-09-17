import java.util.*;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    private Trie root;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        root = new Trie();
        for (String word : wordDict) {
            root.addWord(word);
        }
        backtracking(result, root, new StringBuilder(), s.toCharArray(), 0);

        return result;
    }

    private void backtracking(List<String> result, Trie node, StringBuilder buffer, char[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        if (node.getChild(arr[index]) == null) {
            return;
        }
        Trie next = node.getChild(arr[index]);
        buffer.append(arr[index]);
        if (next.isWord) {
            if (index + 1 == arr.length) {
                result.add(buffer.toString());
                buffer.deleteCharAt(buffer.length() - 1);
                return;
            } else {
                buffer.append(" ");
                backtracking(result, root, buffer, arr, index + 1);
                // Remove the last space
                buffer.deleteCharAt(buffer.length() - 1);
            }
        }
        backtracking(result, next, buffer, arr, index + 1);
        // Remove the character just added
        buffer.deleteCharAt(buffer.length() - 1);
    }

    class Trie {
        boolean isWord;
        private Trie[] child;

        public Trie() {
            isWord = false;
            child = new Trie[26];
        }

        public void addWord(String word) {
            Trie dummy = this;
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                if (dummy.child[arr[i] - 'a'] == null) {
                    dummy.child[arr[i] - 'a'] = new Trie();
                }
                dummy = dummy.child[arr[i] - 'a'];
            }
            dummy.isWord = true;
        }

        public Trie getChild(char c) {
            return this.child[c - 'a'];
        }
    }
}
// @lc code=end

