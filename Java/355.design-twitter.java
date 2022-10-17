import java.util.*;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Twitter {
    private static int timestamp = 0;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
            next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> follows;
        public Tweet head;

        public User(int id) {
            this.id = id;
            follows = new HashSet<>();
            follows.add(id);
            head = null;
        }

        public void follow(int id) {
            follows.add(id);
        }

        public void unfollow(int id) {
            follows.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
    }

    private Map<Integer, User> map;

    public Twitter() {
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new User(userId));
        map.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!map.containsKey(userId)) {
            return result;
        }
        int n = 0;
        Set<Integer> users = map.get(userId).follows;
        PriorityQueue<Tweet> heap = new PriorityQueue<>(users.size(), (t1, t2) -> t2.time - t1.time);
        for (int user : users) {
            Tweet t = map.get(user).head;
            if (t != null) {
                heap.offer(t);
            }
        }
        while (!heap.isEmpty() && n < 10) {
            Tweet t = heap.poll();
            result.add(t.id);
            n++;
            if (t.next != null) {
                heap.offer(t.next);
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            User u = new User(followerId);
            map.put(followerId, u);
        }
        if (!map.containsKey(followeeId)) {
            User u = new User(followeeId);
            map.put(followeeId, u);
        }
        map.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId) || followeeId == followerId) {
            return;
        }
        map.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

