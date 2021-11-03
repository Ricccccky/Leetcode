/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int ptr = m + n - 1;
        while (ptr >= 0) {
            if (i < 0) {
                nums1[ptr--] = nums2[j--];
            } else if (j < 0) {
                nums1[ptr--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[ptr--] = nums1[i--];
            } else {
                nums1[ptr--] = nums2[j--];
            }
        }
    }
}
// @lc code=end
