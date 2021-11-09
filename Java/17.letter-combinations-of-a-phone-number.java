import java.util.*;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    private Map<Character, List<String>> dict = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dict.put('2', Arrays.asList("a", "b", "c"));
        dict.put('3', Arrays.asList("d", "e", "f"));
        dict.put('4', Arrays.asList("g", "h", "i"));
        dict.put('5', Arrays.asList("j", "k", "l"));
        dict.put('6', Arrays.asList("m", "n", "o"));
        dict.put('7', Arrays.asList("p", "q", "r", "s"));
        dict.put('8', Arrays.asList("t", "u", "v"));
        dict.put('9', Arrays.asList("w", "x", "y", "z"));
        backtracking(digits, "", result);

        return result;
    }

    private void backtracking(String digits, String temp, List<String> result) {
        if (digits.length() == temp.length()) {
            result.add(temp);
            return;
        }
        char current = digits.charAt(temp.length());
        for (String letter : dict.get(current)) {
            backtracking(digits, temp + letter, result);
        }
        
        return;
    }
}
// @lc code=end

