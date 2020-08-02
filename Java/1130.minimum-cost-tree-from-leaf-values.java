import java.util.Stack;

/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(16);
        for (int digit : arr) {
            while (stack.peek() <= digit) {
                int min = stack.pop();
                result += min * Math.min(digit, stack.peek());
            }
            stack.push(digit);
        }
        while (stack.size() > 2) {
            result += stack.pop() * stack.peek();
        }
        return result;
    }
}
// @lc code=end

