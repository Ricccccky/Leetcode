import java.util.*;

/*
 * @lc app=leetcode id=353 lang=java
 *
 * [353] Design Snake Game
 */

// @lc code=start
class SnakeGame {
    int width;
    int height;
    int score;
    int foodIdx;
    int[][] food;
    Set<Integer> set;
    Deque<Integer> occupies;
    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        set = new HashSet<>();
        occupies = new LinkedList<>();
        set.add(0);
        occupies.offer(0);
    }
    
    public int move(String direction) {
        if (score == -1) {
            return -1;
        }
        int row = occupies.peek() / width;
        int col = occupies.peek() % width;
        switch (direction) {
            case "U": row--;
                break;
            case "D": row++;
                break;
            case "L": col--;
                break;
            case "R": col++;
                break;
        }
        int head = row * width + col;
        set.remove(occupies.peekLast());
        // Hit the boundaries or body
        if (row < 0 || row == height || col < 0 || col == width || set.contains(head)) {
            score = -1;
            return -1;
        }
        set.add(head);
        occupies.offerFirst(head);
        if (foodIdx < food.length && food[foodIdx][0] == row && food[foodIdx][1] == col) {
            set.add(occupies.peekLast());
            foodIdx++;
            score++;
            return score;
        }
        occupies.pollLast();

        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
// @lc code=end

