import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode id=893 lang=java
 *
 * [893] Groups of Special-Equivalent Strings
 */

// @lc code=start
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> result = new HashSet<>();
        for (String word : A) {
            int[] even = new int[26];
            int[] odd = new int[26];
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even[word.charAt(i) - 'a']++;
                } else {
                    odd[word.charAt(i) - 'a']++;
                }
            }
            result.add(Arrays.toString(even) + Arrays.toString(odd));
        }
        return result.size();
    }
}
// @lc code=end

