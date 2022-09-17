import java.util.*;

/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Integer> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < arr.length; i++, j++) {
            arr[i] = arr[j];
            if (i == 0 || arr[i] != arr[i - 1]) {
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
                if (stack.peek() == k) {
                    stack.pop();
                    i -= k;
                }
            }
        }

        return new String(arr, 0, i);
    }
}
// @lc code=end

