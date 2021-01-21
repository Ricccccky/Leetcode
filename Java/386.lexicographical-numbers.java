import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, res, i);
        }

        return res;
    }

    private void dfs(int n, List<Integer> res, int temp) {
        if (temp > n) {
            return;
        }
        res.add(temp);
        temp *= 10;
        for (int i = 0; i < 10; i++) {
            dfs(n, res, temp + i);
        }
    }
}
// @lc code=end

