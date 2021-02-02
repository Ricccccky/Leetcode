/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // Iterative
        // int[] result = new int[n + 1];
        // result[0] = 1;
        // result[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         result[i] += result[j] * result[i - j - 1];
        //     }
        // }

        // return result[n];

        // Recursive
        int res = 0;
        if (n < 2) {
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                res += numTrees(i) * numTrees(n - i - 1);
            }
        }

        return res;
    }
}
// @lc code=end

