import java.util.*;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[] {building[0], building[2]});
            heights.add(new int[] {building[1], -building[2]});
        }
        Collections.sort(heights, (b1, b2) -> (b1[0] == b2[0] ? b2[1] - b1[1] : b1[0] - b2[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        maxHeap.offer(0);
        int preHeight = 0;
        for (int[] height : heights) {
            if (height[1] > 0) {
                maxHeap.offer(height[1]);
            } else {
                maxHeap.remove(-height[1]);
            }
            int curMax = maxHeap.peek();
            if (curMax != preHeight) {
                res.add(List.of(height[0], curMax));
                preHeight = curMax;
            }
        }
        
        return res;
    }
}
// @lc code=end

