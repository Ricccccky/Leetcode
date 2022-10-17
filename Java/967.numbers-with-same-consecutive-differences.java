import java.util.*;

/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int num : result) {
                int last = num % 10;
                if (last + k < 10) {
                    temp.add(num * 10 + last + k);
                }
                if (k > 0 && last - k >= 0) {
                    temp.add(num * 10 + last - k);
                }
            }
            result = temp;
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

