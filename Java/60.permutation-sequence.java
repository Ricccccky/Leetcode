import java.util.*;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorials = new int[n];
        factorials[0] = 1;
        nums.add(1);
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
            nums.add(i + 1);
        }
        // fit k from [1, n!] to [0, n! - 1]
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int count = k / factorials[i];
            k %= factorials[i];
            sb.append(nums.get(count));
            nums.remove(count);
        }

        return sb.toString();
    }
}
// @lc code=end

