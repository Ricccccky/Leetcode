/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int small = arr.length - 2, large = arr.length - 1;
        StringBuilder sb = new StringBuilder();
        while (small >= 0 && arr[small] >= arr[small + 1]) {
            small--;
        }
        if (small == -1) {
            return -1;
        }
        while (arr[small] >= arr[large]) {
            large--;
        }
        char swap = arr[small];
        arr[small] = arr[large];
        arr[large] = swap;
        for (int i = 0; i <= small; i++) {
            sb.append(arr[i]);
        }
        for (int i = arr.length - 1; i > small; i--) {
            sb.append(arr[i]);
        }
        long result = Long.parseLong(sb.toString());
        
        return result > Integer.MAX_VALUE ? -1 : (int)result;
    }
}
// @lc code=end

