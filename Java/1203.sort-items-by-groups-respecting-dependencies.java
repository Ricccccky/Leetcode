import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=1203 lang=java
 *
 * [1203] Sort Items by Groups Respecting Dependencies
 */

// @lc code=start
class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }
        int[] result = new int[n];
        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];
        Map<Integer, List<Integer>> groupTable = new HashMap<>();
        Map<Integer, List<Integer>> itemTable = new HashMap<>();
        Map<Integer, List<Integer>> item2group = new HashMap<>();
        for (int i = 0; i < n; i++) {
            itemTable.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            groupTable.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            Iterator<Integer> before = beforeItems.get(i).iterator();
            while (before.hasNext()) {
                int fromItem = before.next();
                int fromGroup = group[fromItem];
                if (fromGroup != group[i]) {
                    groupTable.computeIfAbsent(fromGroup, k -> new ArrayList<>()).add(group[i]);
                    groupIndegree[group[i]]++;
                }
                itemTable.computeIfAbsent(fromItem, k -> new ArrayList<>()).add(i);
                itemIndegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> groupOrder = new ArrayList<>();
        for (int key : groupTable.keySet()) {
            if (groupIndegree[key] == 0) {
                queue.offer(key);
            }
        }
        System.out.println(queue);
        int numGroup = 0;
        while (!queue.isEmpty()) {
            int entrance = queue.poll();
            numGroup++;
            groupOrder.add(entrance);
            for (int t : groupTable.get(entrance)) {
                groupIndegree[t]--;
                if (groupIndegree[t] == 0) {
                    queue.offer(t);
                }
            }
        }
        if (numGroup != m) {
            return new int[0];
        }

        queue.clear();
        List<Integer> itemOrder = new ArrayList<>();
        for (int item : itemTable.keySet()) {
            if (itemIndegree[item] == 0) {
                queue.offer(item);
            }
        }
        int numItem = 0;
        while (!queue.isEmpty()) {
            int entrance = queue.poll();
            itemOrder.add(entrance);
            numItem++;
            for (int t : itemTable.get(entrance)) {
                itemIndegree[t]--;
                if (itemIndegree[t] == 0) {
                    queue.offer(t);
                }
            }
        }
        System.out.println(groupOrder);
        if (numItem != n) {
            return new int[0];
        }
        for (Integer item : itemOrder) {
            item2group.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }
        int count = 0;
        for (Integer gp : groupOrder) {
            List<Integer> items = item2group.getOrDefault(gp, new ArrayList<>());
            for (Integer item : items) {
                result[count] = item;
                count++;
            }
        }
        return result;
    }
}
// @lc code=end

