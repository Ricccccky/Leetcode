import java.util.*;

/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int[] dp = new int[n];
        int result = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, result, envelope[1]);
            index = Math.max(index, -(index + 1));
            dp[index] = envelope[1];
            if (result == index) {
                result++;
            }
            // Manually binary search
            // int left = 0;
            // int right = result;
            // while (left < right) {
            //     int mid = left + (right - left) / 2;
            //     if (dp[mid] < envelope[1]) {
            //         left = mid + 1;
            //     } else {
            //         right = mid;
            //     }
            // }
            // dp[left] = envelope[1];
            // if (left == result) {
            //     result++;
            // }
        }

        return result;
    }

    // DP approach, TLE
    // public int maxEnvelopes(int[][] envelopes) {
    //     int n = envelopes.length;
    //     Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
    //     int[] dp = new int[n];
    //     int result = 0;
    //     for (int i = 0; i < n; i++) {
    //         int max = 1;
    //         for (int j = 0; j < i; j++) {
    //             if (envelopes[i][1] > envelopes[j][1]) {
    //                 max = Math.max(max, dp[j] + 1);
    //             }
    //         }
    //         dp[i] = max;
    //     }
    //     for (int i : dp) {
    //         result = Math.max(result, i);
    //     }

    //     return result;
    // }
}
// @lc code=end

