/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    private Trie[] next;
    private String word;
    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new Trie();
            }
            root = root.next[c - 'a'];
        }
        root.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] != null) {
                root = root.next[c - 'a'];
            } else {
                return false;
            }
        }
        if (root.word == null) {
            return false;
        }

        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        for (char c : prefix.toCharArray()) {
            if (root.next[c - 'a'] != null) {
                root = root.next[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

