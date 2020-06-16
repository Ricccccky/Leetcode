import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        int len;
        String top = null;
        char[] letters;
        Queue<String> temp = new LinkedList<>();
        temp.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                continue;
            }
            len = temp.size();
            for (int j = 0; j < len; j++) {
                top = temp.poll();
                letters = top.toCharArray();
                letters[i] = Character.toLowerCase(letters[i]);
                temp.offer(String.valueOf(letters));
                letters[i] = Character.toUpperCase(letters[i]);
                temp.offer(String.valueOf(letters));
            }
        }
        return (List<String>)temp;
    }
}
// @lc code=end

