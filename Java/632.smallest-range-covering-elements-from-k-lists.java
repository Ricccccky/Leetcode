import java.util.*;

/*
 * @lc app=leetcode id=632 lang=java
 *
 * [632] Smallest Range Covering Elements from K Lists
 */

// @lc code=start
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> nums.get(x[0]).get(x[1]) - nums.get(y[0]).get(y[1]));
        int start = 0, end = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            // Merge process of each array
            heap.offer(new int[] {i, 0});
            // Maximum start integer
            max = Math.max(max, nums.get(i).get(0));
        }
        // Smallest integer is on the top of heap
        while (heap.size() == nums.size()) {
            int[] top = heap.poll();
            int row = top[0], col = top[1];
            if (end - start > max - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }
            // Exit the loop if all the integers have been added to the heap
            if (col + 1 < nums.get(row).size()) {
                heap.offer(new int[] {row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }

        return new int[] {start, end};
    }
}
// @lc code=end

