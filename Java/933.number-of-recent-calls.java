import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=933 lang=java
 *
 * [933] Number of Recent Calls
 */

// @lc code=start
class RecentCounter {
    private Queue<Integer> call;
    public RecentCounter() {
        call = new LinkedList<>();
    }
    
    public int ping(int t) {
        while (!call.isEmpty() && call.peek() < t - 3000) {
            call.poll();
        }
        call.offer(t);
        return call.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

