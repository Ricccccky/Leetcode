import java.util.*;

/*
 * @lc app=leetcode id=679 lang=java
 *
 * [679] 24 Game
 */

// @lc code=start
class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) nums.add((double)card);

        return backtracking(nums);
    }

    private boolean backtracking(List<Double> nums) {
        if (nums.size() == 1) {
            if (Math.abs(24 - nums.get(0)) < 0.001) {
                return true;
            }
        }
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                Double x = nums.get(i), y = nums.get(j);
                List<Double> temp = new ArrayList<>();
                temp.addAll(Arrays.asList(x + y, x - y, y - x, x * y));
                if (Math.abs(x) > 0.001) temp.add(y / x);
                if (Math.abs(y) > 0.001) temp.add(x / y);
                nums.remove(i);
                nums.remove(j);
                for (Double d : temp) {
                    nums.add(d);
                    if (backtracking(nums)) return true;
                    nums.remove(nums.size() - 1);
                }
                nums.add(j, y);
                nums.add(i, x);
            }
        }

        return false;
    }
}
// @lc code=end

