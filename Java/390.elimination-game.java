/*
 * @lc app=leetcode id=390 lang=java
 *
 * [390] Elimination Game
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    private int leftToRight(int n) {
        if (n <= 2) {
            return n;
        }

        return 2 * rightToLeft(n / 2);
    }

    private int rightToLeft(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n % 2 == 0) {
            // [1, 2, 3, 4] -> [1, 3] = 2 * [1, 2] - 1
            return 2 * leftToRight(n / 2) - 1;
        } else {
            // [1, 2, 3, 4, 5] -> [2, 4] = 2 * [1, 2]
            return 2 * leftToRight(n / 2);
        }
    }
}
// @lc code=end

