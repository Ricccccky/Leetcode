import java.util.*;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> freq.get(w1) == freq.get(w2) ? w2.compareTo(w1) : freq.get(w1) - freq.get(w2));
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        for (String word : freq.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(0, heap.poll());
        }

        return result;
    }
}
// @lc code=end

