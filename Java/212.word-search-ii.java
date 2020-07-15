import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = TrieNodeBuilder(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                backtracking(board, i, j, root, result);
            }
        }
        return result;
    }

    private void backtracking(char[][] board, int row, int col, TrieNode p, List<String> result) {
        char cur = board[row][col];
        if (cur == '*' || p.next[cur - 'a'] == null) {
            return;
        }
        p = p.next[cur - 'a'];
        if (p.word != null) {
            result.add(p.word);
            p.word = null;
        }

        board[row][col] = '*';
        if (row > 0) {
            backtracking(board, row - 1, col, p, result);
        }
        if (row < board.length - 1) {
            backtracking(board, row + 1, col, p, result);
        }
        if (col > 0) {
            backtracking(board, row, col - 1, p, result);
        }
        if (col < board[0].length - 1) {
            backtracking(board, row, col + 1, p, result);
        }
        board[row][col] = cur;
    }

    private TrieNode TrieNodeBuilder(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new TrieNode();
                }
                p = p.next[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }
}
// @lc code=end

