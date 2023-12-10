/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        Map<String, Set<String>> union = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents.putIfAbsent(account.get(i), account.get(i));
                owners.putIfAbsent(account.get(i), account.get(0));
            }
        }
        for (List<String> account : accounts) {
            String parent = find(parents, account.get(1));
            for (int i = 2; i < account.size(); i++) {
                parents.put(find(parents, account.get(i)), parent);
            }
        }
        for (List<String> account : accounts) {
            String parent = find(parents, account.get(1));
            if (!union.containsKey(parent)) {
                union.put(parent, new HashSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                union.get(parent).add(account.get(i));
            }
        }
        for (String p : union.keySet()) {
            List<String> list = new ArrayList<>(union.get(p));
            Collections.sort(list);
            list.add(0, owners.get(p));
            res.add(list);
        }

        return res;

    }

    private String find(Map<String, String> parents, String account) {
        while (parents.get(account) != account) {
            account = parents.get(account);
        }

        return account;
    }
}
// @lc code=end

