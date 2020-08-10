import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    int iP = findParent(parent, i);
                    int jP = findParent(parent, j);
                    if (iP != jP) {
                        parent[jP] = iP;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                result++;
            }
        }
        return result;
    }

    private int findParent(int[] parent, int k) {
        while (parent[k] != k) {
            k = parent[k];
        }
        return k;
    }
}
// @lc code=end

