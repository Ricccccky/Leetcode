/*
 * @lc app=leetcode id=1655 lang=java
 *
 * [1655] Distribute Repeating Integers
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> freq = new ArrayList<>();
        for (var entry : count.entrySet()) {
            freq.add(entry.getValue());
        }
        // Stop at early step if cannot satisfy large customer
        Arrays.sort(quantity);
        int p = 0, q = quantity.length - 1;
        while (p < q) {
            int tmp = quantity[p];
            quantity[p] = quantity[q];
            quantity[q] = tmp;
            p++;
            q--;
        }

        return backtracking(freq, quantity, 0);
    }

    private boolean backtracking (List<Integer> freq, int[] quantity, int start) {
        if (start == quantity.length) {
            return true;
        }
        int n = freq.size();
        for (int i = 0; i < n; i++) {
            if (freq.get(i) >= quantity[start]) {
                freq.set(i, freq.get(i) - quantity[start]);
                if (backtracking(freq, quantity, start + 1)) {
                    return true;
                }
                freq.set(i, freq.get(i) + quantity[start]);
            }
        }

        return false;
    }
}
// @lc code=end

