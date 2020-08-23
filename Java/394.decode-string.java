import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        String result = "";
        Stack<Integer> nums = new Stack<>();
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num *= 10;
                    num += s.charAt(i) - '0';
                    i++;
                }
                i--;
                nums.push(num);
            } else if (s.charAt(i) == '[') {
                strings.push(result);
                result = "";
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(strings.pop());
                int num = nums.pop();
                for (int j = 0; j < num; j++) {
                    temp.append(result);
                }
                result = temp.toString();
            } else {
                result += s.charAt(i);
            }
        }

        return result;
    }
}
// @lc code=end

