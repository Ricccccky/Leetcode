import java.util.*;

/*
 * @lc app=leetcode id=2386 lang=java
 *
 * [2386] Find the K-Sum of an Array
 */

// @lc code=start
class Solution {
    // TC: O(nlog + klogk)
    public long kSum(int[] nums, int k) {
        long maxSum = 0, minus = 0;
        int n = nums.length;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(p -> p[0]));
        for (int i = 0; i < n; i++) {
            maxSum += Math.max(0, nums[i]);
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        minHeap.offer(new long[] {nums[0], 0});
        while (--k > 0) {
            long[] top = minHeap.poll();
            int index = (int)top[1]++;
            long val = top[0];
            minus = val;
            if (index < nums.length - 1) {
                top[0] += nums[index + 1];
                minHeap.offer(new long[] {val - nums[index] + nums[index + 1], index + 1});
                minHeap.offer(top);
            }
        }

        return maxSum - minus;
    }
}
// @lc code=end

