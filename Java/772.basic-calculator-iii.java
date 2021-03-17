import java.util.Deque;
import java.util.LinkedList;

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
                nums.addFirst(num);
            } else if (c == '(') {
                ops.addFirst(c);
            } else if (c == ')') {
                while (ops.peekFirst() != '(') {
                    nums.addFirst(calculation(ops.removeFirst(), nums.removeFirst(), nums.removeFirst()));
                }
                ops.removeFirst();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && checkOrder(c, ops.peekFirst())) {
                    nums.addFirst(calculation(ops.removeFirst(), nums.removeFirst(), nums.removeFirst()));
                }
                // Dealing with negative numbers
                // if (c == '-') {
                //     if (nums.isEmpty()) {
                //         nums.addFirst(0);
                //     } else {
                //         int idx = i - 1;
                //         while (idx >= 0 && s.charAt(idx) == ' ') {
                //             idx--;
                //         }
                //         if (s.charAt(idx) == '(') {
                //             nums.addFirst(0);
                //         }
                //     }
                // }
                ops.addFirst(c);
            }
        }
        while (!ops.isEmpty()) {
            nums.addFirst(calculation(ops.removeFirst(), nums.removeFirst(), nums.removeFirst()));
        }

        return nums.removeFirst();
    }

    private boolean checkOrder(char op_1, char op_2) {
        if (op_2 == '(' || op_2 == ')') {
            return false;
        }
        if ((op_1 == '*' || op_1 == '/') && (op_2 == '+' || op_2 == '-')) {
            return false;
        }

        return true;
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

