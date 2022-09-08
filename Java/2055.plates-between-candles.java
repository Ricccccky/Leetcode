/*
 * @lc app=leetcode id=2055 lang=java
 *
 * [2055] Plates Between Candles
 */

// @lc code=start
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] result = new int[queries.length];
        int[] nearestLefttCandle = new int[n];
        int[] nearestRightCandle = new int[n];
        int[] candleCount = new int[n];
        int candle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestLefttCandle[i] = candle;
        }
        candle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestRightCandle[i] = candle;
        }
        candle = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                candle++;
            }
            candleCount[i] = candle;
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int leftCandle = nearestRightCandle[start];
            int rightCandle = nearestLefttCandle[end];
            if (leftCandle == -1 || rightCandle == -1) {
                continue;
            } else {
                result[i] = Math.max(0, rightCandle - leftCandle + 1 - (candleCount[rightCandle] - candleCount[leftCandle] + 1));
            }
        }

        return result;
    }
}
// @lc code=end

