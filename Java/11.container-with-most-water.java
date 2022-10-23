/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int result = 0;
        while (p1 <= p2) {
            if (height[p1] > height[p2]) {
                result = Math.max(result, (p2 - p1) * height[p2]);
                p2--;
            } else {
                result = Math.max(result, (p2 - p1) * height[p1]);
                p1++;
            }
        }
        
        return result;
    }
}
// @lc code=end

