import java.util.Stack;

/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] A) {
        int result = 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Stack<int[]> leftStack = new Stack<>();
        Stack<int[]> rightStack = new Stack<>();
        // Dist from previous less number
        for (int i = 0; i < A.length; i++) {
            int len = 1;
            while (!leftStack.isEmpty() && leftStack.peek()[0] >= A[i]) {
                len += leftStack.pop()[1];
            }
            left[i] = len;
            leftStack.push(new int[] {A[i], len});
        }
        // Dist from next less number
        for (int i = A.length - 1; i >= 0 ; i--) {
            int len = 1;
            while (!rightStack.isEmpty() && rightStack.peek()[0] > A[i]) {
                len += rightStack.pop()[1];
            }
            right[i] = len;
            rightStack.push(new int[] {A[i], len});
        }
        for (int i = 0; i < A.length; i++) {
            result += A[i] * (left[i] * right[i]);
            result %= 1e9 + 7;
        }
        return result;
    }
}
// @lc code=end

