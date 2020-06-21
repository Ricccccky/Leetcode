import java.util.HashMap;

/*
 * @lc app=leetcode id=765 lang=java
 *
 * [765] Couples Holding Hands
 */

// @lc code=start
class Solution {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        int result = 0;
        for (int i = 0; i < row.length; i++) {
            temp.put(row[i], i);
        }
        for (int i = 0; i < row.length; i += 2) {
            int couple;
            if (row[i] % 2 == 0) {
                couple = row[i] + 1;
            } else {
                couple = row[i] - 1;
            }
            if (row[i + 1] != couple) {
                int pos = temp.get(couple);
                temp.put(couple, i + 1);
                temp.put(row[i + 1], pos);
                row[pos] = row[i + 1];
                row[i + 1] = couple;
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

