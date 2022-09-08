import java.util.*;

/*
 * @lc app=leetcode id=823 lang=java
 *
 * [823] Binary Trees With Factors
 */

// @lc code=start
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        long result = 0;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] / arr[j], 0L)) % mod);
                }
            }
            result = (result + dp.get(arr[i])) % mod;
        }
        
        return (int)result;
    }
}
// @lc code=end

