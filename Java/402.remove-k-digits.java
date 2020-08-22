/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
// @lc code=end