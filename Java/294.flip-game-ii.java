import java.util.*;

/*
 * @lc app=leetcode id=294 lang=java
 *
 * [294] Flip Game II
 */

// @lc code=start
class Solution {
    public boolean canWin(String currentState) {
        if (currentState.length() < 2) {
            return false;
        }
        
        return canWin(currentState, new HashMap<>());
    }

    private boolean canWin(String currentState, Map<String, Boolean> dp) {
        int n = currentState.length();
        if (dp.containsKey(currentState)) {
            return dp.get(currentState);
        }
        StringBuilder sb = new StringBuilder(currentState);
        for (int i = 0; i < n - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                if (!canWin(sb.toString(), dp)) {
                    dp.put(currentState, true);
                    return true;
                }
                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
        }
        dp.put(currentState, false);

        return false;
    }
}
// @lc code=end

