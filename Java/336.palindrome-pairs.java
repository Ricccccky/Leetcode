import java.util.*;

/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 */

// @lc code=start
class Solution {
    // Hash Table solution
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
            set.add(words[i].length());
        }
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            String reverseStr = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(reverseStr) && map.get(reverseStr) != i) {
                result.add(Arrays.asList(i, map.get(reverseStr)));
            }
            for (int l : set) {
                if (l == len) {
                    break;
                }
                if (isPalindrome(reverseStr, 0, len - l - 1)) {
                    String tail = reverseStr.substring(len - l);
                    if (map.containsKey(tail)) {
                        result.add(Arrays.asList(i, map.get(tail)));
                    }
                }
                if (isPalindrome(reverseStr, l, len - 1)) {
                    String head = reverseStr.substring(0, l);
                    if (map.containsKey(head)) {
                        result.add(Arrays.asList(map.get(head), i));
                    }
                }
            }
        }

        return result;
    }

    // Trie solution
    Trie root = new Trie();
    // public List<List<Integer>> palindromePairs(String[] words) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     int n = words.length;
    //     for (int i = 0; i < n; i++) {
    //         add(words[i], i);
    //     }
    //     for (int i = 0; i < n; i++) {
    //         search(words[i], i, result);
    //     }

    //     return result;
    // }

    private void add(String word, int i) {
        Trie dummy = root;
        for (int j = word.length() - 1; j >= 0; j--) {
            int c = word.charAt(j) - 'a';
            if (dummy.child[c] == null) {
                dummy.child[c] = new Trie();
            }
            if (isPalindrome(word, 0, j)) {
                dummy.list.add(i);
            }
            dummy = dummy.child[c];
        }
        dummy.index = i;
        dummy.list.add(i);
    }

    private void search(String word, int i, List<List<Integer>> result) {
        Trie dummy = root;
        for (int j = 0; j < word.length(); j++) {
            if (dummy.index != -1 && dummy.index != i && isPalindrome(word, j, word.length() - 1)) {
                result.add(Arrays.asList(i, dummy.index));
            }
            dummy = dummy.child[word.charAt(j) - 'a'];
            if (dummy == null) {
                return;
            }
        }
        for (int j : dummy.list) {
            if (i == j) {
                continue;
            }
            result.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start++) != word.charAt(end--)) return false;
        }

        return true;
    }

    class Trie {
        Trie[] child = new Trie[26];
        int index = -1;
        List<Integer> list = new ArrayList<>();

        @Override
        public String toString() {
            return index + ":" + list;
        }
    }
}
// @lc code=end

