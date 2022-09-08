import java.util.*;

/*
 * @lc app=leetcode id=772 lang=java
 *
 * [772] Basic Calculator III
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(calculation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && checkOrder(c, ops.peek())) {
                    nums.push(calculation(ops.pop(), nums.pop(), nums.pop()));
                }
                // Dealing with negative numbers
                // if (c == '-') {
                //     if (nums.isEmpty()) {
                //         nums.push(0);
                //     } else {
                //         int idx = i - 1;
                //         while (idx >= 0 && s.charAt(idx) == ' ') {
                //             idx--;
                //         }
                //         if (s.charAt(idx) == '(') {
                //             nums.push(0);
                //         }
                //     }
                // }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            nums.push(calculation(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    private boolean checkOrder(char op_1, char op_2) {
        if (op_2 == '(') {
            return false;
        }
        
        return op_2 == '*' || op_2 == '/' || op_1 == '+' || op_1 == '-';
    }

    private int calculation (char op, int y, int x) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '/':
                return x / y;
            case '*':
                return x * y;
            default:
                return -1;
        }
    }
}
// @lc code=end

