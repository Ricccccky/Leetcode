import java.util.*;

/*
 * @lc app=leetcode id=489 lang=java
 *
 * [489] Robot Room Cleaner
 */

// @lc code=start
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        backtracking(robot, set, 0, 0, 0);
    }

    private void backtracking(Robot robot, Set<Pair<Integer, Integer>> visited, int x_offset, int y_offset, int cur_dir) {
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        visited.add(new Pair<>(x_offset, y_offset));
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int next_dir = (cur_dir + i) % 4;
            int next_x = x_offset + dirs[next_dir][0];
            int next_y = y_offset + dirs[next_dir][1];
            if (!visited.contains(new Pair<>(next_x, next_y)) && robot.move()) {
                backtracking(robot, visited, next_x, next_y, next_dir);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}
// @lc code=end

