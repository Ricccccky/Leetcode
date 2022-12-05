
/*
 * @lc app=leetcode id=1804 lang=java
 *
 * [1804] Implement Trie II (Prefix Tree)
 */

// @lc code=start
class Trie {
    private Trie[] next;
    private int count;
    private int countPrefix;
    private String word;

    public Trie() {
        next = new Trie[26];
        count = 0;
        countPrefix = 0; 
    }
    
    public void insert(String word) {
        Trie dummy = this;
        for (char c : word.toCharArray()) {
            if (dummy.next[c - 'a'] == null) {
                dummy.next[c - 'a'] = new Trie();
            }
            dummy = dummy.next[c - 'a'];
            dummy.countPrefix++;
        }
        dummy.count++;
        dummy.word = word;
    }
    
    public int countWordsEqualTo(String word) {
        Trie dummy = this;
        for (char c : word.toCharArray()) {
            if (dummy.next[c - 'a'] == null) {
                return 0;
            }
            dummy = dummy.next[c - 'a'];
        }

        return dummy.word == null ? 0 : dummy.count;
    }
    
    public int countWordsStartingWith(String prefix) {
        Trie dummy = this;
        for (char c : prefix.toCharArray()) {
            if (dummy.next[c - 'a'] == null) {
                return 0;
            }
            dummy = dummy.next[c - 'a'];
        }

        return dummy.countPrefix;
    }
    
    public void erase(String word) {
        Trie dummy = this;
        for (char c : word.toCharArray()) {
            dummy = dummy.next[c - 'a'];
            dummy.countPrefix--;
        }
        dummy.count--;
        if (dummy.count == 0) {
            dummy.word = null;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
// @lc code=end

