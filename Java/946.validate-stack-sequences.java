/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, p = 0, q = 0;
        Deque<Integer> stack = new LinkedList();
        Set<Integer> used = new HashSet<>();
        while (p < n && q < n) {
            if (used.contains(popped[q])) {
                if (stack.peek() == popped[q]) {
                    stack.pop();
                    q++;
                } else {
                    return false;
                }
            } else {
                stack.push(pushed[p]);
                used.add(pushed[p++]);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() == popped[q]) {
                q++;
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

