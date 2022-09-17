import java.util.*;

/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            freq.put(num, freq.get(num) - 1);
            if (count.getOrDefault(num - 1, 0) > 0) {
                // Extend the sequence ended in num - 1
                count.put(num - 1, count.get(num - 1) - 1);
                count.put(num, count.getOrDefault(num, 0) + 1);
            } else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                // Construct a new sequence
                count.put(num + 2, count.getOrDefault(num + 2, 0) + 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

