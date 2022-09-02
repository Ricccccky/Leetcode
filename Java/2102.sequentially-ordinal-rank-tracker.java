import java.util.*;

/*
 * @lc app=leetcode id=2102 lang=java
 *
 * [2102] Sequentially Ordinal Rank Tracker
 */

// @lc code=start
class SORTracker {
    private class Location implements Comparable<Location> {
        public String name;
        public int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Location o) {
            if (this.score == o.score) {
                return o.name.compareTo(this.name);
            } else {
                return this.score - o.score;
            }
        }
    }

    PriorityQueue<Location> maxHeap;
    PriorityQueue<Location> minHeap;
    public SORTracker() {
        maxHeap = new PriorityQueue<>((x, y) -> y.compareTo(x));
        minHeap = new PriorityQueue<>((x, y) -> x.compareTo(y));
    }
    
    public void add(String name, int score) {
        Location loca = new Location(name, score);
        if (!minHeap.isEmpty() && minHeap.peek().compareTo(loca) < 0) {
            maxHeap.offer(minHeap.poll());
            minHeap.offer(loca);
        } else {
            maxHeap.offer(loca);
        }
    }
    
    public String get() {
        minHeap.offer(maxHeap.poll());
        return minHeap.peek().name;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
// @lc code=end

