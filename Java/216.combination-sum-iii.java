import java.util.*;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, k, n, new ArrayList<>(), 1);

        return res;
    }

    private void backtracking(List<List<Integer>> res, int k, int n, List<Integer> list, int start) {
        if (n == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
        } else if (n < 0 || list.size() >= k) {
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            backtracking(res, k, n - i, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

