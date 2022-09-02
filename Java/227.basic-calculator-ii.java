import java.util.*;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        int res = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
// @lc code=end

