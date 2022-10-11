import java.util.*;

/*
 * @lc app=leetcode id=2273 lang=java
 *
 * [2273] Find Resultant Array After Removing Anagrams
 */

// @lc code=start
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();
        for (int i = words.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && isAnagrams(words[i], stack.peek())) {
                stack.pop();
            }
            stack.push(words[i]);
        }

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private boolean isAnagrams(String x, String y) {
        int[] arr = new int[26];
        for (char c : x.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : y.toCharArray()) {
            arr[c - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

