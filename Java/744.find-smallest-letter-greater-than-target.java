
/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (letters[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo == letters.length ? letters[0] : letters[lo];
    }
}
// @lc code=end

