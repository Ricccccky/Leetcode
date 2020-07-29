/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int path;
                if (j == triangle.get(i).size() - 1) {
                    path = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    path = dp[i - 1][j] + triangle.get(i).get(j);
                } else {
                    path = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
                dp[i][j] = path;
            }
        }

        int result = dp[dp.length - 1][0];
        for (int path : dp[dp.length - 1]) {
            result = Math.min(result, path);
        }
        return result;
    }
}
// @lc code=end

