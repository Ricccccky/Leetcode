import java.util.*;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    // BFS, TC:O(2^n)
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isValid(s)) {
                result.add(s);
                found = true;
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }
                String tmp = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(tmp)) {
                    queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
// @lc code=end

