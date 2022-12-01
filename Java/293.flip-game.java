import java.util.*;

/*
 * @lc app=leetcode id=293 lang=java
 *
 * [293] Flip Game
 */

// @lc code=start
class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(currentState);
        int n = currentState.length();
        for (int i = 0; i < n - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i) == sb.charAt(i + 1)) {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                result.add(sb.toString());
                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
        }

        return result;
    }
}
// @lc code=end

