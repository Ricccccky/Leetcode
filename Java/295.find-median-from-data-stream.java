import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;
    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(-max.poll());
        if (max.size() < min.size()) {
            max.offer(-min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
            return max.peek();
        } else {
            return (max.peek() - min.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

