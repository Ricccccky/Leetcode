/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int digit = 1;
        while (x / 10 / digit != 0) {
            digit *= 10;
        }

        while (x != 0) {
            if (x / digit != x % 10) {
                return false;
            }
            x %= digit;
            x /= 10;
            digit /= 100;
        }
        
        return true;
    }
}
// @lc code=end

