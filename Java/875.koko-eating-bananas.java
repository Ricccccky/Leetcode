
/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        int r = 0;
        for (int pile : piles) {
            sum += pile;
            r = Math.max(r, pile);
        }
        int l = sum / h;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int time = 0;
            for (int pile : piles) {
                time += Math.ceil((double)pile / mid);
            }
            if (time > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
// @lc code=end

