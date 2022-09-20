import java.util.*;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    // O(nlogn)
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (arr[0].equals("0")) {
            return "0";
        }
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
// @lc code=end

