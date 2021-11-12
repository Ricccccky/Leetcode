import java.util.*;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [][] adjacentMatrix = new int[numCourses][numCourses];
        int [] inDegree = new int[numCourses];
        int numNodes = 0;
        int course;
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int late = prerequisites[i][0];
            if (adjacentMatrix[pre][late] == 0) {
                inDegree[late]++;
            }
            adjacentMatrix[pre][late] = 1;
        }

        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                temp.offer(i);
            }
        }

        while (!temp.isEmpty()) {
            course = temp.poll();
            numNodes++;
            for (int i = 0; i < numCourses; i++) {
                if (adjacentMatrix[course][i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        temp.offer(i);
                    }
                }
            }
        }
        
        return numCourses == numNodes;
    }
}
// @lc code=end

