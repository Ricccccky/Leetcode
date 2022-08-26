import java.util.*;

/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                while (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
// @lc code=end

