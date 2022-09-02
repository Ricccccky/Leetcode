import java.util.*;

/*
 * @lc app=leetcode id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);
        for (int[] box : boxTypes) {
            if (box[0] < truckSize) {
                result += box[0] * box[1];
                truckSize -= box[0];
            } else {
                result += truckSize * box[1];
                break;
            }
        }

        return result;
    }
}
// @lc code=end

