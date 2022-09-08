import java.util.*;
import java.util.function.BiFunction;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (x, y) -> x + y);
        map.put("-", (x, y) -> x - y);
        map.put("*", (x, y) -> x * y);
        map.put("/", (x, y) -> x / y);
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (map.containsKey(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(map.get(token).apply(op1, op2));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
// @lc code=end

