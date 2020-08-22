import java.util.Arrays;
import java.util.stream.Collectors;

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
        int left = begin;
        int right = begin;
        int pivot = nums[end];
        if (begin < end) {
            for (; right < end; right++) {
                if (nums[right] > pivot) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
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
        } else {
            return pivot;
        }
    }
}
// @lc code=end

