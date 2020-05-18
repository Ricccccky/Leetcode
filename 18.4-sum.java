import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.jvm.hotspot.gc.shared.ContiguousSpace;

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

        Map<Integer, List<List<Integer>>> numMap = new HashMap<>();
        Arrays.sort(nums);
        if (nums[0] * 4 > target || nums[nums.length - 1] * 4 < target) {
            return result;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }

            for (int j = i - 1; j > -1; j--) {
                if (j < i - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                List<List<Integer>> temp;
                if (!numMap.containsKey(nums[i] + nums[j])) {
                    temp = new ArrayList<>();
                    temp.add(Arrays.asList(j, i));
                    numMap.put(nums[i] + nums[j], temp);
                } else {
                    temp = numMap.get(nums[i] + nums[j]);
                    temp.add(Arrays.asList(j, i));
                    numMap.put(nums[i] + nums[j], temp);
                }
            }
        }
        System.out.println(numMap);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int diff = target - nums[i] - nums[j];
                System.out.println(diff);
                if (numMap.containsKey(diff)) {
                    for (List<Integer> pair : numMap.get(diff)) {
                        if (pair.get(0) > j) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[pair.get(0)], nums[pair.get(1)]));
                        }
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

