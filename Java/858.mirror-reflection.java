/*
 * @lc app=leetcode id=858 lang=java
 *
 * [858] Mirror Reflection
 */

// @lc code=start
class Solution {
    public int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        while (n * q != m * p) {
            n++;
            m = n * q / p;
        }
        if (m % 2 == 0 && n % 2 == 1) {
            return 0;
        }
        if (m % 2 == 1 && n % 2 == 1) {
            return 1;
        }
        if (m % 2 == 1 && n % 2 == 0) {
            return 2;
        }
        
        return -1;
    }
}
// @lc code=end

