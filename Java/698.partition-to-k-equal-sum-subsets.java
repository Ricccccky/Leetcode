import java.util.*;

/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
class Solution {
    // O(n2^n)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        char[] used = new char[n];
        Map<String, Boolean> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.fill(used, '0');
        // Start from the largest number
        Arrays.sort(nums);
        
        return backtracking(nums, n - 1, k, 0, sum / k, used, map);
    }

    private boolean backtracking(int[] nums, int index, int count, int curSum, int target, char[] used, Map<String, Boolean> map) {
        if (count == 0) {
            return true;
        }
        if (curSum > target) {
            return false;
        }
        int n = nums.length;
        String usedStr = new String(used);
        if (map.containsKey(usedStr)) {
            return map.get(usedStr);
        }
        if (curSum == target) {
            boolean result = backtracking(nums, n - 1, count - 1, 0, target, used, map);
            // Save current number usage status
            map.put(usedStr, result);
            return result;
        }
        for (int i = index; i >= 0; i--) {
            if (used[i] == '0') {
                used[i] = '1';
                if (backtracking(nums, i - 1, count, curSum + nums[i], target, used, map)) {
                    return true;
                }
                used[i] = '0';
            }
        }
        map.put(usedStr, false);

        return false;
    }
}
// @lc code=end

