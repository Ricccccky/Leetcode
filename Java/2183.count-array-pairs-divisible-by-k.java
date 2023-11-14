/*
 * @lc app=leetcode id=2183 lang=java
 *
 * [2183] Count Array Pairs Divisible by K
 */

// @lc code=start

import java.util.*;

class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> mapGCD = new HashMap<>();
        long res = 0;
        for (int num : nums) {
            // Obtain common factors of k from i
            int i = getGCD(num, k);
            for (var entry : mapGCD.entrySet()) {
                int j = entry.getKey();
                int count = entry.getValue();
                // Common factors of k from i and j must be able to combine k
                if ((long) i * j % k == 0) {
                    res += count;
                }
            }
            mapGCD.put(i, mapGCD.getOrDefault(i, 0) + 1);
        }

        return res;
    }

    private int getGCD(int x, int y) {
        if (x < y) {
            return getGCD(y, x);
        }
        while (x % y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }

        return y;
    }
}
// @lc code=end

