
/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String S) {
        int sum = 0;
        // Using stack
        // Deque<Integer> stack = new LinkedList<>();
        // for (char c : S.toCharArray()) {
        //     if (c == '(') {
        //         stack.push(sum);
        //         sum = 0;
        //     } else {
        //         sum = stack.pop() + Math.max(2 * sum, 1);
        //     }
        // }

        // Count parentheses layer
        char[] arr = S.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (arr[i] == ')' && arr[i - 1] == '(') {
                sum += 1 << count;
            }
        }

        return sum;
    }
}
// @lc code=end

