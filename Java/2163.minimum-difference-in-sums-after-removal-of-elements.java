import java.util.*;

/*
 * @lc app=leetcode id=2163 lang=java
 *
 * [2163] Minimum Difference in Sums After Removal of Elements
 */

// @lc code=start
class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long result = Long.MAX_VALUE;
        long sumFirst = 0, sumSecond = 0;
        long[] diffSum = new long[n + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            sumFirst += nums[i];
            maxHeap.offer(nums[i]);
            sumSecond += nums[i + 2 * n];
            minHeap.offer(nums[i + 2 * n]);
        }
        for (int split = n; split <= 2 * n; split++) {
            diffSum[split - n] = sumFirst;
            if (maxHeap.peek() > nums[split]) {
                sumFirst += nums[split] - maxHeap.peek();
                maxHeap.poll();
                maxHeap.offer(nums[split]);
            }
        }
        for (int split = 2 * n - 1; split >= n - 1; split--) {
            diffSum[split - n + 1] -= sumSecond;
            if (minHeap.peek() < nums[split]) {
                sumSecond += nums[split] - minHeap.peek();
                minHeap.poll();
                minHeap.offer(nums[split]);
            }
            result = Math.min(result, diffSum[split - n + 1]);
        }

        return result;
    }
}
// @lc code=end

