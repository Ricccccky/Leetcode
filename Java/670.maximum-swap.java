import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int[] pos = new int[10];
        for (int i = 0; i < nums.length; i++) {
            pos[nums[i] - '0'] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 9; j > nums[i] - '0'; j--) {
                if (pos[j] > i) {
                    char temp = nums[i];
                    nums[i] = nums[pos[j]];
                    nums[pos[j]] = temp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}
// @lc c9973ode=end

