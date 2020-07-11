import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtracking(result, "", 0, 0, n);
        return result;
    }

    private void backtracking(List<String> result, String temp, int left, int right, int n) {
        if (temp.length() == 2 * n) {
            result.add(temp);
            return;
        }
        if (left < n) {
            backtracking(result, temp + "(", left + 1, right, n);
        }
        if (left > right) {
            backtracking(result, temp + ")", left, right + 1, n);
        }
        return;
    }
}
// @lc code=end

