/*
 * @lc app=leetcode id=1287 lang=java
 *
 * [1287] Element Appearing More Than 25% In Sorted Array
 */

// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] nums = new int[] {arr[n / 4], arr[n / 2], arr[n * 3 / 4]};
        for (int i : nums) {
            int start = binarySearch(arr, i);
            int end = binarySearch(arr, i + 1) - 1;
            if (end - start + 1 > n / 4) {
                return i;
            }
        }

        return -1;
    }

    private int binarySearch(int[] arr, int target) {
        int n = arr.length, l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
// @lc code=end

