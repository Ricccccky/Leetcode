/*
 * @lc app=leetcode id=1901 lang=java
 *
 * [1901] Find a Peak Element II
 */

// @lc code=start
class Solution {
    // O(m+n)
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int rowLo = 0, rowHi = m - 1;
        int colLo = 0, colHi = n - 1;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (rowHi - rowLo >= 2 && colHi - colLo >= 2) {
            if (rowHi - rowLo > colHi - colLo) {
                int mid = rowLo + (rowHi - rowLo) / 2;
                int max = colLo;
                boolean isPeak = true;
                for (int i = colLo; i <= colHi; i++) {
                    if (mat[mid][max] < mat[mid][i]) {
                        max = i;
                    }
                }
                for (int[] dir : dirs) {
                    int x = mid + dir[0];
                    int y = max + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        isPeak = isPeak && mat[mid][max] > mat[x][y];
                    }
                }
                if (isPeak) {
                    return new int[] {mid, max};
                } else if (mat[mid][max] < mat[mid - 1][max]) {
                    rowHi = mid;
                } else {
                    rowLo = mid;
                }
            } else {
                int mid = colLo + (colHi - colLo) / 2;
                int max = rowLo;
                boolean isPeak = true;
                for (int i = rowLo; i <= rowHi; i++) {
                    if (mat[max][mid] < mat[i][mid]) {
                        max = i;
                    }
                }
                for (int[] dir : dirs) {
                    int x = max + dir[0];
                    int y = mid + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        isPeak = isPeak && mat[max][mid] > mat[x][y];
                    }
                }
                if (isPeak) {
                    return new int[] {max, mid};
                } else if (mat[max][mid] < mat[max][mid - 1]) {
                    colHi = mid;
                } else {
                    colLo = mid;
                }
            }
        }
        int max = 0, x = 0, y = 0;
        for (int i = rowLo; i <= rowHi; i++) {
            for (int j = colLo; j <= colHi; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        return new int[] {x, y};
    }

    // O(mlogn)
    // public int[] findPeakGrid(int[][] mat) {
    //     int m = mat.length, n = mat[0].length;
    //     int lo = 0, hi = n - 1;
    //     while (lo <= hi) {
    //         int mid = lo + (hi - lo) / 2;
    //         int max = 0;
    //         for (int i = 0; i < m; i++) {
    //             if (mat[max][mid] < mat[i][mid]) {
    //                 max = i;
    //             }
    //         }
    //         if ((mid == 0 || mat[max][mid] > mat[max][mid - 1]) && (mid == n - 1 || mat[max][mid] > mat[max][mid + 1])) {
    //             return new int[] {max, mid};
    //         } else if (mid > 0 && mat[max][mid] < mat[max][mid - 1]) {
    //             hi = mid - 1; 
    //         } else {
    //             lo = mid + 1;
    //         }
    //     }

    //     return new int[] {-1, -1};
    // }
}
// @lc code=end

