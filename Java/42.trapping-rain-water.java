
/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int leftWall = 0;
        int rightWall = 0;
        int result = 0;
        while (p1 < p2) {
            leftWall = Math.max(height[p1], leftWall);
            rightWall = Math.max(height[p2], rightWall);
            if (leftWall < rightWall) {
                // leftWall is the short slab, pick leftWall as enclosure, p1 must be shorter than p2
                result += (leftWall - height[p1]);
                p1++;
            } else {
                // rightWall is the short slab, pick rightWall as enclosure, p2 must be shorter than p1
                result += (rightWall - height[p2]);
                p2--;
            }
        }
        
        return result;
    }
}
// @lc code=end

