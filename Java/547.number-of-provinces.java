
/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int x = find(roots, i);
                    int y = find(roots, j);
                    if (x != y) {
                        roots[y] = x;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (roots[i] == i) {
                res++;
            }
        }

        return res;
    }

    private int find(int[] roots, int city) {
        while (city != roots[city]) {
            city = roots[city];
        }

        return city;
    }
}
// @lc code=end

