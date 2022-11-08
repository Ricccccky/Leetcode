import java.util.*;

/*
 * @lc app=leetcode id=1465 lang=java
 *
 * [1465] Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

// @lc code=start
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
        Arrays.sort(verticalCuts);
        Arrays.sort(horizontalCuts);
        long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
        long maxW = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        for (int i = 1; i < m; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < n; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int)(maxH * maxW % 1000000007);
    }
}
// @lc code=end

