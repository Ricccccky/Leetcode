/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int p1 = 0;
        int result = 0;
        while (p1 < n) {
            int p2 = p1;
            if (p2 + 1 < n && arr[p2] < arr[p2 + 1]) {
                while (p2 + 1 < n && arr[p2] < arr[p2 + 1]) {
                    p2++;
                }
                if (p2 + 1 < n && arr[p2] > arr[p2 + 1]) {
                    while (p2 + 1 < n && arr[p2] > arr[p2 + 1]) {
                        p2++;
                    }
                    result = Math.max(result, p2 - p1 + 1);
                }
            }
            p1 = Math.max(p1 + 1, p2);
        }

        return result;
    }
}
// @lc code=end

