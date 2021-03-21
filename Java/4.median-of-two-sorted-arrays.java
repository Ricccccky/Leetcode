/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int begin = 0;
        int end = len1;
        while (begin <= end) {
            int i = (begin + end) / 2;
            // len1 < len2 guarantees j is non-negative
            // len(left_part) = len(right_part)
            int j = (len1 + len2 + 1) / 2 - i;
            if (i < len1 && nums1[i] < nums2[j - 1]) {
                begin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            } else {
                int left_max;
                if (i == 0) {
                    left_max = nums2[j - 1];
                } else if (j == 0) {
                    left_max = nums1[i - 1];
                } else {
                    left_max = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len1 + len2) % 2 == 1) {
                    return left_max;
                }
                
                int right_min;
                if (i == len1) {
                    right_min = nums2[j];
                } else if (j == len2) {
                    right_min = nums1[i];
                } else {
                    right_min = Math.min(nums1[i], nums2[j]);
                }
                return (double)(left_max + right_min) / 2.0;
            }
        }
        return -1;
    }
}
// @lc code=end

