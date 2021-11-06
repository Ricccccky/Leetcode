import java.util.*;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return diffWaysToCompute(expression, 0, expression.length());
    }

    public List<Integer> diffWaysToCompute(String expression, int start, int end) {
        List<Integer> res = new ArrayList<>();
        Set<Character> set = new HashSet<>(Set.of('+', '-', '*'));
        for (int i = start; i < end; i++) {
            char c = expression.charAt(i);
            if (set.contains(c)) {
                List<Integer> front = diffWaysToCompute(expression, start, i);
                List<Integer> rear = diffWaysToCompute(expression, i + 1, end);
                for (int f : front) {
                    for (int r : rear) {
                        if (c == '+') {
                            res.add(f + r);
                        } else if (c == '-') {
                            res.add(f - r);
                        } else {
                            res.add(f * r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression.substring(start, end)));
        }

        return res;
    }
}
// @lc code=end

