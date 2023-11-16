/*
 * @lc app=leetcode id=754 lang=java
 *
 * [754] Reach a Number
 */

// @lc code=start

import java.util.*;

class Solution {
    public int reachNumber(int target) {
        int res = 0;
        target = Math.abs(target);
        while (target > 0) {
            res += 1;
            target -= res;
        }

        return target % 2 == 0? res : (target + res + 1) % 2 + res + 1;
    }
}
// @lc code=end

