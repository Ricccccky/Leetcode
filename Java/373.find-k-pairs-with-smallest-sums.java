import java.util.*;

/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> p1[0] + p1[1] - p2[0] - p2[1]);
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[] {nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            result.add(List.of(top[0], top[1]));
            if (top[2] == nums2.length - 1) {
                continue;
            }
            minHeap.offer(new int[] {top[0], nums2[top[2] + 1], top[2] + 1});
        }

        return result;
    }
}
// @lc code=end

