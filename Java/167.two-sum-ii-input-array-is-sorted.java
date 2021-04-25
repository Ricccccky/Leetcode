/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int idx = binarySearch(numbers, i + 1, target - numbers[i]);
            if (idx != -1) {
                return new int[] {i + 1, idx + 1};
            }
        }

        return new int[0];
    }

    private int binarySearch(int[] numbers, int start, int target) {
        int lo = start;
        int hi = numbers.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
// @lc code=end

