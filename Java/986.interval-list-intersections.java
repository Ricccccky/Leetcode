import java.util.*;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int pA = 0, pB = 0;
        while (pA < A.length && pB < B.length) {
            if (A[pA][0] > B[pB][1]) {
                pB++;
            } else if (A[pA][1] < B[pB][0]) {
                pA++;
            } else {
                list.add(new int[] {Math.max(A[pA][0], B[pB][0]), Math.min(A[pA][1], B[pB][1])});
                if (A[pA][1] > B[pB][1]) {
                    pB++;
                } else {
                    pA++;
                }
            }
        }
        return list.toArray(new int[0][]);
    }
}
// @lc code=end

