import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length == 1) {
            return 1;
        }
        if (tree.length == 2) {
            return 2;
        }
        int start = 0;
        int end = 1;
        int basket1 = tree[start];
        int basket2 = -1;
        int result = 0;
        int[] temp = new int[tree.length + 1];
        temp[basket1] = start;
        while (end < tree.length) {
            if (tree[end] != basket1 && tree[end] != basket2) {
                if (basket2 == -1) {
                    basket2 = tree[end];
                    temp[basket2] = end;
                } else {
                    result = Math.max(result, end - start);
                    if (temp[basket1] < temp[basket2]) {
                        start = temp[basket1] + 1;
                        basket1 = tree[end];
                        temp[basket1] = end;
                    } else {
                        start = temp[basket2] + 1;
                        basket2 = tree[end];
                        temp[basket2] = end;
                    }
                }
            } else if (tree[end] == basket1) {
                temp[basket1] = end;
            } else {
                temp[basket2] = end;
            }
            end++;
        }
        result = Math.max(result, end - start);
        return result;
    }
}
// @lc code=end

