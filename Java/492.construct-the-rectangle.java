/*
 * @lc app=leetcode id=492 lang=java
 *
 * [492] Construct the Rectangle
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int W = 1; W <= Math.sqrt(area); W++) {
            if (area % W == 0) {
                int L = area / W;
                if (Math.abs(W - L) < diff) {
                    result[0] = L;
                    result[1] = W;
                    diff = Math.abs(W - L);
                }
            }
        }

        return result;
    }
}
// @lc code=end

