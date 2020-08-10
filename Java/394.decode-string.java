import java.util.HashMap;
import java.util.Map;
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
        Stack<Integer> num = new Stack<>();
        Stack<String> word = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                num.push(count);
            } else if (s.charAt(i) == '[') {
                word.push(result);
                result = "";
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(word.pop());
                int count = num.pop();
                for (int j = 0; j < count; j++) {
                    temp.append(result);
                }
                result = temp.toString();
            } else {
                result += s.charAt(i);
            }
        }
        return result.toString();
    }
}
// @lc code=end

