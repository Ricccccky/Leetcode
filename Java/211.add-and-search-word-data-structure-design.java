/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start
class WordDictionary {
    private WordDictionary[] next;
    private boolean isWord;
    /** Initialize your data structure here. */
    public WordDictionary() {
        next = new WordDictionary[26];
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary root = this;
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new WordDictionary();
            }
            root = root.next[c - 'a'];
        }
        root.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        WordDictionary root = this;
        return match(word, 0, root);
    }

    private boolean match(String word, int index, WordDictionary node) {
        if (index == word.length()) {
            return node.isWord;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null && match(word, index + 1, node.next[i])) {
                    return true;
                }
            }
        } else {
            if (node.next[word.charAt(index) - 'a'] != null) {
                return match(word, index + 1, node.next[word.charAt(index) - 'a']);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

