/*
 * @lc app=leetcode id=1864 lang=java
 *
 * [1864] Minimum Number of Swaps to Make the Binary String Alternating
 */

// @lc code=start
class Solution {
    public int minSwaps(String s) {
        int ones = 0, zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        if (Math.abs(ones - zeros) > 1) {
            return -1;
        }
        if (ones > zeros) {
            return oddPosCount(s, '1');
        } else if (ones < zeros) {
            return oddPosCount(s, '0');
        } else {
            return Math.min(oddPosCount(s, '0'), oddPosCount(s, '1'));
        }
    }

    private int oddPosCount(String s, char letter) {
        int swap = 0;
        for (char c : s.toCharArray()) {
            if (c != letter) {
                swap++;
            }
            letter = (char)('1' + '0' - letter);
        }

        return swap / 2;
    }
}
// @lc code=end

