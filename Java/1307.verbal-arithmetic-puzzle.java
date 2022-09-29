import java.util.*;

/*
 * @lc app=leetcode id=1307 lang=java
 *
 * [1307] Verbal Arithmetic Puzzle
 */

// @lc code=start
class Solution {
    // Time: O(n!) Space: O(n)
    public boolean isSolvable(String[] words, String result) {
        List<Character> list = new ArrayList<>();
        int maxLen = 2, minLen = 5;
        boolean[] used = new boolean[10];
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }
        maxLen = Math.max(maxLen, result.length());
        minLen = Math.min(minLen, result.length());
        for (int i = 0; i < maxLen; i++) {
            for (String word : words) {
                if (word.length() <= i) {
                    continue;
                }
                char c = word.charAt(word.length() - i - 1);
                if (!list.contains(c)) {
                    list.add(c);
                }
            }
            if (result.length() > i) {
                char c = result.charAt(result.length() - i - 1);
                if (!list.contains(c)) {
                    list.add(c);
                }
            }
        }

        return backtracking(list, maxLen, minLen, 0, map, used, result, words);
    }

    private boolean backtracking(List<Character> list, int maxLen, int minLen, int index, int[] map, boolean[] used, String result, String[] words) {
        if (index == list.size()) {
            return isValid(map, result, words);
        }
        if (!isValid(map, result, words, minLen)) {
            return false;
        }
        char c = list.get(index);
        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                map[c - 'A'] = i;
                if (backtracking(list, maxLen, minLen, index + 1, map, used, result, words)) {
                    return true;
                }
                used[i] = false;
                map[c - 'A'] = -1;
            }
        }

        return false;
    }

    private boolean isValid(int[] map, String result, String[] words) {
        int[] nums = new int[words.length];
        int sum = 0;
        int target = calculate(result, map);
        if (target == -1) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            nums[i] = calculate(words[i], map);
            if (nums[i] == -1) {
                return false;
            }
        }
        for (int num : nums) {
            sum += num;
        }

        return sum == target;
    }

    private boolean isValid(int[] map, String result, String[] words, int minLen) {
        int carry = 0;
        for (int i = 0; i < minLen; i++) {
            char c = result.charAt(result.length() - i - 1);
            int sum = 0;
            if (map[c - 'A'] == -1) {
                return true;
            }
            for (String word : words) {
                char cc = word.charAt(word.length() - i - 1);
                if (map[cc - 'A'] == -1) {
                    return true;
                }
                sum += map[cc - 'A'];
            }
            sum += carry;
            if (sum % 10 != map[c - 'A']) {
                return false;
            }
            carry = sum / 10;
        }

        return true;
    }

    private int calculate(String word, int[] map) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int num = map[c - 'A'];
            if (i == 0 && word.length() > 1 && num == 0) {
                return -1;
            }
            sum = sum * 10 + num;
        }

        return sum;
    }
}
// @lc code=end

