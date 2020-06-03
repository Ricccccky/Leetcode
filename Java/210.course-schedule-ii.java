import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjacentMatrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        int course;
        int count = 0;
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
            result[count] = course;
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (adjacentMatrix[course][i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        temp.offer(i);
                    }
                }
            }
        }

        if (count == numCourses) {
            return result;
        } else {
            return new int[] {};
        }
    }
}
// @lc code=end

