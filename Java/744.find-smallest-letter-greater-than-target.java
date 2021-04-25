import java.util.Arrays;

/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] > target) {
                hi = mid;
            } else if (letters[mid] <= target) {
                lo = mid + 1;
            }
        }

        return letters[lo % letters.length];
    }
}
// @lc code=end

