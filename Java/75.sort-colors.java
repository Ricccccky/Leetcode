import org.graalvm.compiler.lir.LIRInstruction.Temp;

/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // Two-pass
        // int[] counter = {0, 0, 0};
        // for (int i = 0; i < nums.length; i ++) {
        //     counter[nums[i]]++;
        // }
        // for (int i = 0; i < counter[0]; i++) {
        //     nums[i] = 0;
        // }

        // for (int i = counter[0]; i < counter[0] + counter[1]; i++) {
        //     nums[i] = 1;
        // }

        // for (int i = counter[0] + counter[1]; i < counter[0] + counter[1] + counter[2]; i++) {
        //     nums[i] = 2;
        // }

        //One-pass
        int p0 = -1;
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == 1) {
                p1++;
            } else if (nums[p1] == 2) {
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p2--;
            } else if (nums[p1] == 0) {
                p0++;
                int temp = nums[p1];
                nums[p1] = nums[p0];
                nums[p0] = temp;
                p1++;
            }
        }
    }
}
// @lc code=end

