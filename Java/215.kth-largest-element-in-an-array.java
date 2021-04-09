import java.util.Random;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int begin, int end, int k) {
        if (begin == end) {
            return nums[end];
        }
        Random rand = new Random();
        int left = begin;
        int right = begin;
        swap(nums, rand.nextInt(end - begin) + begin, end);
        int pivot = nums[end];
        for (; right < end; right++) {
            if (nums[right] > pivot) {
                swap(nums, left++, right);
            }
        }
        nums[right] = nums[left];
        nums[left] = pivot;
        if (left - begin == k - 1) {
            return pivot;
        } else if (left - begin > k - 1) {
            return findKthLargest(nums, begin, left - 1, k);
        } else {
            return findKthLargest(nums, left + 1, end, k - left + begin - 1);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
// @lc code=end

