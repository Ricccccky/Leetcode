import java.util.*;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, candidates, new ArrayList<>(), 0, target);

        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] candidates, List<Integer> temp, int start, int remain) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else if (remain < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtracking(result, candidates, temp, i, remain - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// @lc code=end

