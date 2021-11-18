import java.util.*;

/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int n = matchsticks.length;
        for (int m : matchsticks) {
            sum += m;
        }
        if (sum % 4 != 0) {
            return false;
        }
        sum /= 4;
        Arrays.sort(matchsticks);
        for (int i = 0; i < n / 2; i++) {
            matchsticks[i] ^= matchsticks[n - i - 1];
            matchsticks[n - i - 1] =  matchsticks[i] ^ matchsticks[n - i - 1];
            matchsticks[i] ^= matchsticks[n - i - 1];
        }

        return dfs(matchsticks, 0, new int[4], sum);
    }

    private boolean dfs(int[] matchsticks, int idx, int[] sides, int side) {
        if (idx == matchsticks.length) {
            if (sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[idx] <= side) {
                sides[i] += matchsticks[idx];
                if (dfs(matchsticks, idx + 1, sides, side)) {
                    return true;
                }
                sides[i] -= matchsticks[idx];
            }
        }

        return false;
    }
}
// @lc code=end

