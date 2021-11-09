import java.util.*;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new boolean[nums.length], new ArrayList<>());

        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, boolean[] used, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(nums, result, used, temp);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

        return;
    }
}
// @lc code=end

