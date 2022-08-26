import java.util.*;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        // Iterative
        // String result = "";
        // Deque<Integer> count = new LinkedList<>();
        // Deque<String> stack = new LinkedList<>();
        // char[] arr = s.toCharArray();
        // for (int i = 0; i < arr.length; i++) {
        //     if (Character.isDigit(arr[i])) {
        //         int num = 0;
        //         while (Character.isDigit(arr[i])) {
        //             num = num * 10 + arr[i++] - '0';
        //         }
        //         count.push(num);
        //         i--;
        //     } else if (arr[i] == '[') {
        //         stack.push(result);
        //         result = "";
        //     } else if (arr[i] == ']') {
        //         StringBuilder sb = new StringBuilder(stack.pop());
        //         int num = count.pop();
        //         while (num-- > 0) {
        //             sb.append(result);
        //         }
        //         result = sb.toString();
        //     } else {
        //         result += String.valueOf(arr[i]);
        //     }
        // }

        // return result;

        // Recursive
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }

        return decodeString(queue);
    }

    private String decodeString(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String tmp = decodeString(queue);
                while (num > 0) {
                    sb.append(tmp);
                    num--;
                }
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
// @lc code=end

