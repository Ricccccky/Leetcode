import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=1547 lang=java
 *
 * [1547] Minimum Cost to Cut a Stick
 */

// @lc code=start
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for (int cut : cuts) {
            list.add(cut);
        }
        list.add(0);
        list.add(n);
        int len = list.size();
        Collections.sort(list);
        int[][] dp = new int[len][len];
        for (int l = 2; l < len; l++) {
            for (int j = 0; j < len - l; j++) {
                dp[j][j + l] = Integer.MAX_VALUE;
                int price = list.get(j + l) - list.get(j);
                for (int k = j + 1; k < j + l; k++) {
                    dp[j][j + l] = Math.min(dp[j][j + l], dp[j][k] + dp[k][j + l] + price);
                }
            }
        }

        return dp[0][len - 1];
    }
}
// @lc code=end

