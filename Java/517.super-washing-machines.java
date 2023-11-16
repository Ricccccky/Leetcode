/*
 * @lc app=leetcode id=517 lang=java
 *
 * [517] Super Washing Machines
 */

// @lc code=start
class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length, sum = 0, avg = 0, res = 0;
        int[] leftSum = new int[n], rightSum = new int[n];
        for (int dress : machines) {
            sum += dress;
        }
        if (sum % n != 0) {
            return -1;
        }
        avg = sum / n;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + machines[i - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            rightSum[j] = rightSum[j + 1] + machines[j + 1];
        }
        for (int i = 0; i < n; i++) {
            int expLeft = avg * i, expRight = avg * (n - i - 1);
            int pass2Left = 0, pass2Right = 0;
            if (expLeft > leftSum[i]) {
                pass2Left = expLeft - leftSum[i];
            }
            if (expRight > rightSum[i]) {
                pass2Right = expRight - rightSum[i];
            }
            res = Math.max(res, pass2Left + pass2Right);
        }

        return res;

    }
}
// @lc code=end

