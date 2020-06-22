/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int result = 0;
        int sum = 0;
        int[] temp = new int[A.length + 1];
        temp[sum]++;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= S) {
                result += temp[sum - S];
            }
            temp[sum]++;
        }
        return result;
    }
}
// @lc code=end

