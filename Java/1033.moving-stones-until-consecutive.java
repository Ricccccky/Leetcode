import java.util.Arrays;

/*
 * @lc app=leetcode id=1033 lang=java
 *
 * [1033] Moving Stones Until Consecutive
 */

// @lc code=start
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = new int[] {a, b, c};
        Arrays.sort(stones);
        int min = 0;
        int max = stones[2] - stones[1] - 1 + stones[1] - stones[0] - 1;
        if (stones[2] - stones[1] == 1 || stones[1] - stones[0] == 1) {
            if (stones[2] - stones[1] > 1 || stones[1] - stones[0] > 1) {
                min = 1;
            } else {
                min = 0;
            }
        } else if (stones[2] - stones[1] == 2 || stones[1] - stones[0] == 2) {
            min = 1;
        } else {
            min = 2;
        }
        return new int[] {min, max};
    }
}
// @lc code=end

