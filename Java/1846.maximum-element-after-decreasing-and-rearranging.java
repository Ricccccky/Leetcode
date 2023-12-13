/*
 * @lc app=leetcode id=1846 lang=java
 *
 * [1846] Maximum Element After Decreasing and Rearranging
 */

// @lc code=start

import java.util.*;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 0;
        for (int num : arr) {
            prev = Math.min(num, prev + 1);
        }

        return prev;
    }
}
// @lc code=end

