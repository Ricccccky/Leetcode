import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            List<Integer> prev = res.get(res.size() - 1);
            tmp.add(1);
            for (int j = 1; j < prev.size(); j++) {
                tmp.add(prev.get(j) + prev.get(j - 1));
            }
            tmp.add(1);
            res.add(tmp);
        }

        return res;
    }
}
// @lc code=end

