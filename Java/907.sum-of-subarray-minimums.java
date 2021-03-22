import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        int mod = 1000000007;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int len = 1;
            while (!stack.isEmpty() && stack.peekFirst()[0] >= arr[i]) {
                len += stack.removeFirst()[1];
            }
            left[i] = len;
            stack.addFirst(new int[] {arr[i], len});
        }
        stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int len = 1;
            while (!stack.isEmpty() && stack.peekFirst()[0] > arr[i]) {
                len += stack.removeFirst()[1];
            }
            right[i] = len;
            stack.addFirst(new int[] {arr[i], len});
        }
        for (int i = 0; i < n; i++) {
            res += arr[i] * (long)left[i] * (long)right[i];
            res %= mod;
        }
        return (int)res;
    }
}
// @lc code=end

