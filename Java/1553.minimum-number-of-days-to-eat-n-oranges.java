import java.util.*;

/*
 * @lc app=leetcode id=1553 lang=java
 *
 * [1553] Minimum Number of Days to Eat N Oranges
 */

// @lc code=start
class Solution {
    public int minDays(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        
        return dfs(n, dp);
    }

    private int dfs(int n, Map<Integer, Integer> dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int result = n;
        result = Math.min(result, n % 2 + dfs(n / 2, dp));
        result = Math.min(result, n % 3 + dfs(n / 3, dp));
        result++;
        dp.put(n, result);

        return result;
    }
}
// @lc code=end

