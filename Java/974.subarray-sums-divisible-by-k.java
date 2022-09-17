import java.util.*;

/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0, sum = 0;
        // Sum-Count pair
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int a : A) {
            sum += a;
            int mod = sum % K;
            if (mod < 0) {
                mod += K;
            }
            res += map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return res;
    }
}
// @lc code=end

