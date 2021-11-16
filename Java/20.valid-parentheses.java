import java.util.*;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }

        char[] data = s.toCharArray();
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '(' || data[i] == '{' || data[i] == '[') {
                temp.push(data[i]);
            }
            if (data[i] == ')' || data[i] == '}' || data[i] == ']') {
                if (temp.isEmpty()) {
                    return false;
                }
                char top = temp.pop();
                if (data[i] == ')' && top == '(') {
                    continue;
                } else if (data[i] == '}' && top == '{') {
                    continue;
                } else if (data[i] == ']' && top == '[') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (!temp.isEmpty()) {
            return false;
        }
        return true;
    }
}
// @lc code=end

