import java.util.*;

/*
 * @lc app=leetcode id=254 lang=java
 *
 * [254] Factor Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = getFactors(n, 2, new HashMap<>());
        result.remove(0);
        
        return result;
    }

    private List<List<Integer>> getFactors(int n, int start, Map<Integer, List<List<Integer>>> memo) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(n));
        for (int i = start; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                for (List<Integer> list : getFactors(n / i, i, memo)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.addAll(list);
                    result.add(temp);
                }
            }
        }
        memo.put(n, result);

        return result;
    }
}
// @lc code=end

