import java.util.*;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, result, new ArrayList<>(), new boolean[nums.length]);

        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                used[i] = true;
                backtracking(nums, result, new ArrayList<>(temp), used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// @lc code=end

