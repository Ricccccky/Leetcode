import java.util.*;

/*
 * @lc app=leetcode id=1845 lang=java
 *
 * [1845] Seat Reservation Manager
 */

// @lc code=start
class SeatManager {
    private PriorityQueue<Integer> heap;
    public SeatManager(int n) {
        heap = new PriorityQueue<>();
        heap.offer(1);
    }
    
    public int reserve() {
        int result = heap.poll();
        if (heap.isEmpty()) {
            heap.offer(result + 1);
        }

        return result;
    }
    
    public void unreserve(int seatNumber) {
        heap.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
// @lc code=end

