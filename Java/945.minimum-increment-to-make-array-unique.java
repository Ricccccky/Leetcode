import java.util.*;

/*
 * @lc app=leetcode id=945 lang=java
 *
 * [945] Minimum Increment to Make Array Unique
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] A) {
        int result = 0;
        int next = 0;
        Arrays.sort(A);
        for (int n : A) {
            if (n < next) {
                result += next - n;
            }
            next = Math.max(next, n) + 1;
        }

        return result;
    }
}
// @lc code=end

