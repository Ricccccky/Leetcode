import java.util.*;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), n, k, 1);

        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtracking(result, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

