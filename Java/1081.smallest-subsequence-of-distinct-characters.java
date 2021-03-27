import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @lc app=leetcode id=1081 lang=java
 *
 * [1081] Smallest Subsequence of Distinct Characters
 */

// @lc code=start
class Solution {
    public String smallestSubsequence(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            last[c - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek() - 'a']) {
                set.remove(stack.remove());
            }
            stack.addFirst(c);
            set.add(c);
        }
        while (!stack.isEmpty()) {
            res.append(stack.removeLast());
        }
        
        return res.toString();
    }
}
// @lc code=end

