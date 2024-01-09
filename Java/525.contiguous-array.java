/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        diffMap.put(0, -1);
        int cnt = 0, res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt--;
            }
            if (diffMap.containsKey(cnt)) {
                res = Math.max(res, i - diffMap.get(cnt));
            } else {
                diffMap.put(cnt, i);
            }
        }

        return res;
    }
}
// @lc code=end

