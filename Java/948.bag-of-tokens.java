import java.util.*;

/*
 * @lc app=leetcode id=948 lang=java
 *
 * [948] Bag of Tokens
 */

// @lc code=start
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int result = 0, score = 0;
        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l++];
                score++;
                result = Math.max(result, score);
            } else if (score > 0) {
                power += tokens[r--];
                score--;
            } else {
                break;
            }
        }

        return result;
    }
}
// @lc code=end

