import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        int n = nums.length - k + 1;
        double[] res = new double[n];
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            minHeap.add(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() + minHeap.size() == k) {
                if (maxHeap.size() > minHeap.size()) {
                    res[i - k + 1] = (double)maxHeap.peek();
                } else {
                    res[i - k + 1] = (double)((long)maxHeap.peek() + (long)minHeap.peek()) / 2;
                }
                if (!maxHeap.remove(nums[i - k + 1])) {
                    minHeap.remove(nums[i - k + 1]);
                }
            }
        }
        
        return res;
    }
}
// @lc code=end

