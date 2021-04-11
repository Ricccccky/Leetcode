
/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = height.length - 1;
        int left = 0;
        int right = 0;
        int result = 0;
        while (p1 <= p2) {
            left = Math.max(height[p1], left);
            right = Math.max(height[p2], right);
            if (left < right) {
                result += (left - height[p1]);
                p1++;
            } else {
                result += (right - height[p2]);
                p2--;
            }
        }
        return result;
    }
}
// @lc code=end

