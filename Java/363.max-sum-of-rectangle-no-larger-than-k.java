import java.util.TreeSet;

/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int large = Math.max(matrix.length, matrix[0].length);
        int small = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < small; i++) {
            int[] temp = new int[large];
            for (int j = i; j >= 0; j--) {
                TreeSet<Integer> set = new TreeSet<>();
                int cur = 0;
                set.add(0);
                for (int t = 0; t < large; t++) {
                    if (large == matrix.length) {
                        temp[t] += matrix[t][j];
                    } else {
                        temp[t] += matrix[j][t];
                    }
                    cur += temp[t];
                    if (set.ceiling(cur - k) != null) {
                        result = Math.max(result, cur - set.ceiling(cur - k));
                    }
                    set.add(cur);
                }
            }
        }
        return result;
    }
}
// @lc code=end

