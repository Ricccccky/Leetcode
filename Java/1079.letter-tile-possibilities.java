/*
 * @lc app=leetcode id=1079 lang=java
 *
 * [1079] Letter Tile Possibilities
 */

// @lc code=start
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] counter = new int[26];
        for (char c : tiles.toCharArray()) {
            counter[c - 'A']++;
        }
        return dfs(counter);
    }

    private int dfs(int[] freq) {
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            result++;
            freq[i]--;
            result += dfs(freq);
            freq[i]++;
        }
        return result;
    }
}
// @lc code=end

