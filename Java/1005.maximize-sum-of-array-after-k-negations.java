import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        int result = 0;
        for (int i : A) {
            temp.add(i);
        }
        for (int i = 0; i < K; i++) {
            temp.add(-temp.poll());
        }
        for (int i = 0; i < A.length; i++) {
            result += temp.poll();
        }
        return result;
    }
}
// @lc code=end

