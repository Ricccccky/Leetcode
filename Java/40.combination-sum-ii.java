import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, result, new ArrayList<>(), 0, target);
        return result;
    }

    private void backtracking(int[] candidates, List<List<Integer>> result, List<Integer> temp, int start, int remain) {
        if (remain == 0) {
            result.add(temp);
        } else if (remain < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                backtracking(candidates, result, new ArrayList<>(temp), i + 1, remain - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
        return;
    }
}
// @lc code=end

