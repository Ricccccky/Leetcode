/*
 * @lc app=leetcode id=1539 lang=java
 *
 * [1539] Kth Missing Positive Number
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        /*
         * l is the first index we have at least k missing numebrs, so we want to start from l - 1.
         * arr[l - 1] - (l - 1) - 1 missing number at l - 1, we need additional k - (arr[l - 1] - (l - 1) - 1) missing numbers.
         * The target number should be k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1] = k + l.
         */

        return k + left;
    }
}
// @lc code=end

