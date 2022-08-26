import java.util.*;

/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class Solution {
    class TrieNode {
        List<String> words;
        TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
            words = new ArrayList<>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode root = generateTrie(products);
        for (char c : searchWord.toCharArray()) {
            root = root.child[c - 'a'];
            if (root == null) {
                break;
            } else {
                result.add(root.words);
            }
        }
        while (result.size() < searchWord.length()) {
            result.add(new ArrayList<>());
        }

        return result;
    }

    private TrieNode generateTrie (String[] words) {
        Arrays.sort(words);
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode dummy = root;
            char[] arr = word.toCharArray();
            for (char c : arr) {
                if (dummy.child[c - 'a'] == null) {
                    dummy.child[c - 'a'] = new TrieNode();
                }
                dummy = dummy.child[c - 'a'];
                if (dummy.words.size() < 3) {
                    dummy.words.add(word);
                }
            }
        }

        return root;
    }
}
// @lc code=end

