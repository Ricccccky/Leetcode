/*
 * @lc app=leetcode id=1125 lang=java
 *
 * [1125] Smallest Sufficient Team
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        int[] res;
        List<Integer>[] dp = new List[1 << n];
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int curSkill = 0;
            for (String s : people.get(i)) {
                curSkill |= 1 << skillMap.get(s);
            }
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] == null) {
                    continue;
                }
                int comb = curSkill | j;
                if (dp[comb] == null || dp[comb].size() > 1 + dp[j].size()) {
                    dp[comb] = new ArrayList<>(dp[j]);
                    dp[comb].add(i);
                }
            }
        }
        res = new int[dp[(1 << n) - 1].size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[(1 << n) - 1].get(i);
        }

        return res;
    }
}
// @lc code=end

