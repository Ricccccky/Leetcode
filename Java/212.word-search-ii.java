import java.util.*;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    class TrieNode {
        TrieNode[] next;
        String word;

        public TrieNode() {
            next = new TrieNode[26];
        }

        public TrieNode(String[] words) {
            next = new TrieNode[26];
            for (String word : words) {
                TrieNode p = this;
                for (char c : word.toCharArray()) {
                    if (p.next[c - 'a'] == null) {
                        p.next[c - 'a'] = new TrieNode();
                    }
                    p = p.next[c - 'a'];
                }
                p.word = word;
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                backtracking(board, i, j, root, result);
            }
        }
        return result;
    }

    private void backtracking(char[][] board, int row, int col, TrieNode root, List<String> result) {
        char cur = board[row][col];
        if (cur == '*' || root.next[cur - 'a'] == null) {
            return;
        }
        root = root.next[cur - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[row][col] = '*';
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                backtracking(board, x, y, root, result);
            }
        }
        board[row][col] = cur;
    }
}
// @lc code=end

