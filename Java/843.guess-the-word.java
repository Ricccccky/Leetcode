import java.util.*;

/*
 * @lc app=leetcode id=843 lang=java
 *
 * [843] Guess the Word
 */

// @lc code=start
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random rand = new Random();
        for (int i = 0, match = 0; i < 10 && match != 6; i++) {
            String guess = wordlist[rand.nextInt(wordlist.length)];
            match = master.guess(guess);
            List<String> candi = new ArrayList<>();
            for (String word : wordlist) {
                if (match == getMatch(guess, word)) {
                    candi.add(word);
                }
            }
            wordlist = candi.toArray(new String[0]);
        }
    }

    private int getMatch(String s1, String s2) {
        int match = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                match++;
            }
        }

        return match;
    }
}
// @lc code=end

