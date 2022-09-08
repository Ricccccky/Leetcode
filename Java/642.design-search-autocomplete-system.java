import java.util.*;

/*
 * @lc app=leetcode id=642 lang=java
 *
 * [642] Design Search Autocomplete System
 */

// @lc code=start
class AutocompleteSystem {
    private class Trie {
        Map<String, Integer> count;
        Map<Character, Trie> child;

        public Trie() {
            child = new HashMap<>();
            count = new HashMap<>();
        }
    }
    
    String prefix;
    Trie root;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return result;
        }
        PriorityQueue<Pair<String, Integer>> heap = new PriorityQueue<>((x, y) -> x.getValue() == y.getValue() ? x.getKey().compareTo(y.getKey()) : y.getValue() - x.getValue());
        Trie dummy = root;
        prefix += c;
        for (char k : prefix.toCharArray()) {
            Trie next = dummy.child.get(k);
            if (next == null) {
                return result;
            }
            dummy = next;
        }
        for (String s : dummy.count.keySet()) {
            heap.offer(new Pair<>(s, dummy.count.get(s)));
        }
        for (int i = 0; i < 3 && !heap.isEmpty(); i++) {
            result.add(heap.poll().getKey());
        }

        return result;
    }

    private void add(String s, int count) {
        Trie dummy = root;
        for (char c : s.toCharArray()) {
            Trie next = dummy.child.get(c);
            if (next == null) {
                next = new Trie();
                dummy.child.put(c, next);
            }
            dummy = next;
            dummy.count.put(s, dummy.count.getOrDefault(s, 0) + count);
        }

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
// @lc code=end

