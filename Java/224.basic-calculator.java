import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        int op = 0;
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                op = 10 * op + (c - '0');
            } else if (c == '+') {
                res += sign * op;
                op = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * op;
                op = 0;
                sign = -1;
            } else if (c == '(') {
                stack.addFirst(res);
                stack.addFirst(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * op;
                res *= stack.removeFirst();
                res += stack.removeFirst();
                op = 0;
            }
        }

        return res + sign * op;
    }
}
// @lc code=end

