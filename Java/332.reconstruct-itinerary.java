import java.util.*;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> adjTable = new HashMap<>();
        Deque<String> stack = new LinkedList<>();
        for (List<String> ticket : tickets) {
            adjTable.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adjTable.get(ticket.get(0)).offer(ticket.get(1));
        }
        stack.push("JFK");
        // DFS
        while (!stack.isEmpty()) {
            String top = stack.peek();
            if (adjTable.containsKey(top) && !adjTable.get(top).isEmpty()) {
                stack.push(adjTable.get(top).poll());
            } else {
                result.add(0, stack.pop());
            }
        }
        return result;
    }
}
// @lc code=end

