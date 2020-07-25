import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return mostK(A, K) - mostK(A, K - 1);

    }

    private int mostK(int[] A, int K) {
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int p1 = 0, p2 = 0;
        while (p2 < A.length) {
            if (count.getOrDefault(A[p2], 0) == 0) {
                K--;
            }
            count.put(A[p2], count.getOrDefault(A[p2], 0) + 1);
            p2++;
            while (K < 0) {
                count.put(A[p1], count.get(A[p1]) - 1);
                if (count.get(A[p1]) == 0) {
                    K++;
                }
                p1++;
            }
            result += p2 - p1 + 1;
        }
        return result;
    }
}
// @lc code=end

