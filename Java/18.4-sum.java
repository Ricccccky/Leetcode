import java.util.*;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        Map<Long, List<int[]>> numMap = new HashMap<>();
        Arrays.sort(nums);

        // get all 2sum from nums, store the 2sum-index pair pairs in numMap, index[0] < index[1]
        for (int i = nums.length - 1; i > 0; i--) {
            // skip repeated number
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                // skip repeated number
                if (j < i - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                long sum = nums[i] + nums[j];
                if (!numMap.containsKey(sum)) {
                    List<int[]> temp = new ArrayList<>();
                    temp.add(new int[] {j ,i});
                    numMap.put(sum, temp);
                } else {
                    List<int[]> temp = numMap.get(sum);
                    temp.add(new int[] {j ,i});
                    numMap.put(sum, temp);
                }
            }
        }

        for (int i = 0; i < nums.length - 3; i++) {
            // skip repeated number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // skip repeated number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long diff = (long)target - nums[i] - nums[j];
                if (numMap.containsKey(diff)) {
                    for (int[] pair : numMap.get(diff)) {
                        if (pair[0] > j) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[pair[0]], nums[pair[1]]));
                        }
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

