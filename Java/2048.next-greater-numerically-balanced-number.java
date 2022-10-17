/*
 * @lc app=leetcode id=2048 lang=java
 *
 * [2048] Next Greater Numerically Balanced Number
 */

// @lc code=start
class Solution {
    public int nextBeautifulNumber(int n) {
        int result = 1224444;
        int[] map = new int[] {1, 22, 122, 333, 1333, 4444, 14444, 22333, 55555, 122333, 155555, 224444, 666666};
        String target = Integer.toString(n);
        for (int i : map) {
            String str = Integer.toString(i);
            if (str.length() < target.length()) {
                continue;
            }
            if (str.length() > target.length()) {
                result = Math.min(result, i);
            } else {
                while (str != null) {
                    if (str.compareTo(target) > 0) {
                        result = Math.min(Integer.parseInt(str), result);
                    }                   
                    str = nextPermutation(str);
                }
            }
        }

        return result;
    }

    private String nextPermutation(String s) {
        char[] nums = s.toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            char temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        } else {
            return null;
        }

        return String.valueOf(nums);
    }
}
// @lc code=end

