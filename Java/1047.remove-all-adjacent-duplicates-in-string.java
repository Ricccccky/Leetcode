import java.util.Stack;

/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.empty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
// @lc code=end

