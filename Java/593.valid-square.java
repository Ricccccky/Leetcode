/*
 * @lc app=leetcode id=593 lang=java
 *
 * [593] Valid Square
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(getDistance(p1, p2));
        set.add(getDistance(p1, p3));
        set.add(getDistance(p1, p4));
        set.add(getDistance(p2, p3));
        set.add(getDistance(p2, p4));
        set.add(getDistance(p3, p4));

        return set.size() == 2 && !set.contains(0);
    }

    private int getDistance(int[] x, int[] y) {
        return (x[1] - y[1]) * (x[1] - y[1]) + (x[0] - y[0]) * (x[0] - y[0]);
    }
}
// @lc code=end

