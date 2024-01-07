import java.util.*;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int m = nums.length, n = m - k + 1, p = 1;
        double[] res = new double[n];
        TreeSet<Integer> left = new TreeSet<>((x, y) -> nums[x] == nums[y] ? y - x : Integer.compare(nums[y], nums[x]));
        TreeSet<Integer> right = new TreeSet<>((x, y) -> nums[x] == nums[y] ? x - y : Integer.compare(nums[x], nums[y]));
        for (int i = 0; i < k; i++) {
            left.add(i);
        }
        // right is larger
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
        res[0] = getMedian(nums, left, right);
        for (int i = k; i < m; i++) {
            // TreeSet.remove() is O(logn)
            if (!left.remove(i - k)) {
                right.remove(i - k);
            }
            right.add(i);
            left.add(right.pollFirst());
            if (left.size() > right.size()) {
                right.add(left.pollFirst());
            }
            res[p++] = getMedian(nums, left, right);
        }

        return res;
    }

    private double getMedian(int[] nums, TreeSet<Integer> left, TreeSet<Integer> right) {
        if (left.size() < right.size()) {
            return (double)nums[right.first()];
        } else {
            return ((double)nums[left.first()] + nums[right.first()]) / 2;
        }
    }
}
// @lc code=end

