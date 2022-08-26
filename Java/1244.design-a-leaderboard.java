import java.util.*;

/*
 * @lc app=leetcode id=1244 lang=java
 *
 * [1244] Design A Leaderboard
 */

// @lc code=start
class Leaderboard {
    private Map<Integer, Integer> map;
    private TreeMap<Integer, Integer> board;
    public Leaderboard() {
        map = new HashMap<>();
        board = new TreeMap<>((s1, s2) -> Integer.compare(s2, s1));
    }
    
    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            int prev = map.get(playerId);
            board.put(prev, board.get(prev) - 1);
            map.put(playerId, prev + score);
            board.put(prev + score, board.getOrDefault(prev + score, 0) + 1);
        } else {
            map.put(playerId, score);
            board.put(score, board.getOrDefault(score, 0) + 1);
        }
    }
    
    public int top(int K) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : board.entrySet()) {
            if (entry.getValue() >= K) {
                res += entry.getKey() * K;
                break;
            } else {
                res += entry.getValue() * entry.getKey();
                K -= entry.getValue();
            }
        }

        return res;
    }
    
    public void reset(int playerId) {
        int prev = map.get(playerId);
        board.put(prev, board.get(prev) - 1);
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
// @lc code=end

