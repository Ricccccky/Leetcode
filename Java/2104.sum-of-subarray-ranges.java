import java.util.*;

/*
 * @lc app=leetcode id=2104 lang=java
 *
 * [2104] Sum of Subarray Ranges
 */

// @lc code=start
class Solution {
    // O(N^2)
    // public long subArrayRanges(int[] nums) {
    //     long result = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         int max = nums[i], min = nums[i];
    //         for (int j = i; j < nums.length; j++) {
    //             max = Math.max(max, nums[j]);
    //             min = Math.min(min, nums[j]);
    //             result += (long)(max - min);
    //         }
    //     }

    //     return result;
    // }

    // O(N)
    public long subArrayRanges(int[] nums) {
        long result = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        // Sum of max value of all subarrays
        for (int r = 0; r <= n; r++) {
            while (!stack.isEmpty() && nums[stack.peekFirst()] < (r < n ? nums[r] : Integer.MAX_VALUE)) {
                int top = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peekFirst();
                result += (long)nums[top] * (top - l) * (r - top);
            }
            stack.push(r);
        }
        stack.clear();

        // Sum of min value of all subarrays
        for (int r = 0; r <= n; r++) {
            while (!stack.isEmpty() && nums[stack.peekFirst()] > (r < n ? nums[r] : Integer.MIN_VALUE)) {
                int top = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peekFirst();
                result -= (long)nums[top] * (top - l) * (r - top);
            }
            stack.push(r);
        }

        return result;
    }
}
// @lc code=end

