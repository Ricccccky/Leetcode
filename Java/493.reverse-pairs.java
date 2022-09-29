/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }
    
    private int reversePairs(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        } else {
            int mid = start + (end - start) / 2;
            int count = reversePairs(nums, start, mid) + reversePairs(nums, mid + 1, end);
            int j = mid + 1;
            // nums[start:mid] and nums[mid + 1:end] are sorted in non-decreasing order separately
            for (int i = start; i <= mid; i++) {
                while (j <= end && nums[i] > 2L * nums[j]) {
                    j++;
                }
                count += j - mid - 1;
            }
            merge(nums, start, end, mid);
            return count;
        }
    }
    
    private void merge(int[] nums, int start, int end, int mid) {
        int num_l = mid - start + 1, num_r = end - mid;
        int[] L = new int[num_l];
        int[] R = new int[num_r];
        for (int i = 0; i < num_l; i++) {
            L[i] = nums[start + i];
        }
        for (int i = 0; i < num_r; i++) {
            R[i] = nums[mid + i + 1];
        }
        // Merge sorted arrays
        int i = 0, j = 0, k = start;
        for (; k <= end; k++) {
            if (i >= num_l || j >= num_r) {
                break;
            }
            if (L[i] > R[j]) {
                nums[k] = R[j++];
            } else {
                nums[k] = L[i++];
            }
        }
        if (i < num_l) {
            while (k <= end) {
                nums[k++] = L[i++];
            }
        } else if (j < num_r) {
            while (k <= end) {
                nums[k++] = R[j++];
            }
        }
    }
}
// @lc code=end

