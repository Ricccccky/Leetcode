/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 */

// @lc code=start

import java.util.*;

class MagicDictionary {
    private Map<Integer, Set<String>> lenMap;

    public MagicDictionary() {
        lenMap = new HashMap<>();    
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int len = s.length();
            lenMap.putIfAbsent(len, new HashSet<>());
            lenMap.get(len).add(s);
        }
    }
    
    public boolean search(String searchWord) {
        int n = searchWord.length();
        if (!lenMap.containsKey(n)) {
            return false;
        } else {
            for (String s : lenMap.get(n)) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (searchWord.charAt(i) != s.charAt(i)) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
// @lc code=end

