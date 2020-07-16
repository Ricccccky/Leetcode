import java.util.Arrays;

/*
 * @lc app=leetcode id=1040 lang=java
 *
 * [1040] Moving Stones Until Consecutive II
 */

// @lc code=start
class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        int max = Math.max(stones[n - 2] - stones[0] - n + 2, stones[n - 1] - stones[1] - n + 2);
        int min = max;
        int start = 0;
        for (int i = 0; i < n; i++) {
            while (stones[i] - stones[start] >= n) {
                start++;
            }
            if (i - start + 1 == n - 1 && stones[i] - stones[start] == n - 2) {
                min = Math.min(min, 2);
            } else {
                min = Math.min(min, n - (i - start + 1));
            }
        }
        return new int[] {min, max};
    }
}
// @lc code=end

