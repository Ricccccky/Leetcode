import java.util.*;

/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }

        return canIWin(maxChoosableInteger, desiredTotal, new HashMap<>(), 0);
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> dp, int used) {
        if (desiredTotal <= 0) {
            return false;
        }
        if (dp.containsKey(used)) {
            return dp.get(used);
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ((used & 1 << i) > 0) {
                continue;
            }
            used |= 1 << i;
            if (!canIWin(maxChoosableInteger, desiredTotal - i, dp, used)) {
                used &= Integer.MAX_VALUE ^ 1 << i;
                dp.put(used, true);
                return true;
            }
            used &= Integer.MAX_VALUE ^ 1 << i;
        }
        dp.put(used, false);

        return false;
    }
}
// @lc code=end

