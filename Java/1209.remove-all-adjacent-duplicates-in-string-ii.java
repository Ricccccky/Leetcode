import java.util.*;

/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
                if (stack.peekFirst() == k) {
                    stack.pop();
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }

        return sb.toString();
    }
}
// @lc code=end

