/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int prev = i == 0 ? flowerbed[0] : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? flowerbed[flowerbed.length - 1]: flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }

        return count >= n;
    }
}
// @lc code=end

