import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=945 lang=java
 *
 * [945] Minimum Increment to Make Array Unique
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        int res = 0;
        int duplicate = 0;
        for (int n : A) {
            count[n]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                duplicate += count[i] - 1;
                res -= i * (count[i] - 1);
            } else if (duplicate > 0 && count[i] == 0) {
                duplicate--;
                res += i;
            }
        }

        return res;
    }
}
// @lc code=end

