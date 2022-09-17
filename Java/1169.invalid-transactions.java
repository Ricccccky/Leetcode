import java.util.*;

/*
 * @lc app=leetcode id=1169 lang=java
 *
 * [1169] Invalid Transactions
 */

// @lc code=start
class Solution {
    // O(n)
    // public List<String> invalidTransactions(String[] transactions) {
    //     Map<Integer, Map<String, Set<String>>> map = new HashMap<>();
    //     List<String> result = new ArrayList<>();
    //     for (String transaction : transactions) {
    //         String[] arr = transaction.split(",");
    //         int time = Integer.parseInt(arr[1]);
    //         map.putIfAbsent(time, new HashMap<>());
    //         map.get(time).computeIfAbsent(arr[0], x -> new HashSet<>()).add(arr[3]);
    //     }
    //     for (String transaction : transactions) {
    //         String[] arr = transaction.split(",");
    //         int time = Integer.parseInt(arr[1]);
    //         int amount = Integer.parseInt(arr[2]);
    //         if (amount > 1000) {
    //             result.add(transaction);
    //             continue;
    //         }
    //         for (int i = -60; i < 61; i++) {
    //             if (!map.containsKey(time + i)) {
    //                 continue;
    //             }
    //             if (!map.get(time + i).containsKey(arr[0])) {
    //                 continue;
    //             }
    //             if (map.get(time + i).get(arr[0]).size() > 1 || !map.get(time + i).get(arr[0]).iterator().next().equals(arr[3])) {
    //                 result.add(transaction);
    //                 break;
    //             }
    //         }
    //     }

    //     return result;
    // }

    // Intuitive solution, O(n^2)
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

