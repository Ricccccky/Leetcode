import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1169 lang=java
 *
 * [1169] Invalid Transactions
 */

// @lc code=start
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        Map<String, List<String[]>> map = new HashMap<>();
        for (String transaction : transactions) {
            String[] trans = transaction.split(",");
            map.putIfAbsent(trans[0], new ArrayList<>());
            map.get(trans[0]).add(trans);
        }
        for (String transaction : transactions) {
            String[] trans = transaction.split(",");
            if (Integer.parseInt(trans[2]) > 1000) {
                res.add(transaction);
            } else {
                for (String[] prev : map.get(trans[0])) {
                    if (Math.abs(Integer.parseInt(trans[1]) - Integer.parseInt(prev[1])) <= 60 && !trans[3].equals(prev[3])) {
                        res.add(transaction);
                        break;
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end

