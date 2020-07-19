import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        List<Integer> result = Arrays.stream(digits).boxed().collect(Collectors.toList());
        for (int i = result.size() - 1; i > 0; i--) {
            if (result.get(i) >= 10) {
                result.set(i - 1, result.get(i - 1) + result.get(i) / 10);
                result.set(i, result.get(i) % 10);
            }
        }
        if (result.get(0) >= 10) {
            int temp = result.get(0);
            result.set(0, temp % 10);
            result.add(0, temp / 10);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

