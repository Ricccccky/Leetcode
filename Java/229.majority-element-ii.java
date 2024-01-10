/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start

import java.util.*;

class Solution {
    // Boyer-Moore Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length, p = Integer.MIN_VALUE, q = Integer.MIN_VALUE, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (p != Integer.MIN_VALUE && p == num) {
                cnt1++;
            } else if (q != Integer.MIN_VALUE && q == num) {
                cnt2++;
            } else if (cnt1 == 0) {
                p = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                q = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == p) cnt1++;
            if (num == q) cnt2++;
        }
        if (cnt1 > n / 3) res.add(p);
        if (cnt2 > n / 3) res.add(q);

        return res;
    }
}
// @lc code=end

