import java.util.Arrays;

/*
 * @lc app=leetcode id=1356 lang=java
 *
 * [1356] Sort Integers by The Number of 1 Bits
 */

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        // Multiply a number large enough to ensure the priority of the number of 1 bits
        int bigNum = 10001;
        for (int i = 0; i < n; i++) {
            arr[i] += countBit(arr[i]) * bigNum;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            arr[i] %= bigNum;
        }

        return arr;
    }

    private int countBit(int num) {
        int result = 0;
        while (num > 0) {
            result += num & 1;
            num >>= 1;
        }

        return result;
    }
}
// @lc code=end

