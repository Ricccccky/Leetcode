import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> adjTable = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (adjTable.containsKey(ticket.get(0))) {
                adjTable.get(ticket.get(0)).add(ticket.get(1));
            } else {
                PriorityQueue<String> temp = new PriorityQueue<>();
                temp.add(ticket.get(1));
                adjTable.put(ticket.get(0), temp);
            }
        }
        Stack<String> temp = new Stack<>();
        temp.push("JFK");
        while (!temp.isEmpty()) {
            if (adjTable.containsKey(temp.peek()) && !adjTable.get(temp.peek()).isEmpty()) {
                temp.push(adjTable.get(temp.peek()).poll());
            } else {
                result.add(0, temp.pop());
            }
        }
        return result;
    }
}
// @lc code=end

