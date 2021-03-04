import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(words, (w1, w2) -> Integer.compare(w1.length(), w2.length()));
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            boolean[] dp = new boolean[word.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= word.length(); i++) {
                for (int j = i; j >= 0; j--) {
                    if (dp[j] && set.contains(word.subSequence(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (dp[word.length()]) {
                res.add(word);
            }
            set.add(word);
        }

        return res;
    }
}
// @lc code=end

