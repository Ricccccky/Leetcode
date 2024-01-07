/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtracking(res, num, "", target, 0, 0, 0);

        return res;
    }

    private void backtracking(List<String> res, String num, String exp, int target, int pos, long eval, long prev) {
        if (pos == num.length() && target == eval) {
            res.add(new String(exp));
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // If leading zero in [pos, i + 1]?
            if (i > pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                backtracking(res, num, Long.toString(cur), target, i + 1, cur, cur);
            } else {
                backtracking(res, num, exp + "+" + cur, target, i + 1, eval + cur, cur);
                backtracking(res, num, exp + "-" + cur, target, i + 1, eval - cur, -cur);
                backtracking(res, num, exp + "*" + cur, target, i + 1, eval - prev + prev * cur, prev * cur);
            }
        }
    }
}
// @lc code=end

