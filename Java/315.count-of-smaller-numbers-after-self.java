import java.util.*;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] smaller = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        mergeSort(nums, smaller, pos, 0, n - 1);
        for (int i = 0; i < nums.length; i++) {
            result.add(smaller[i]);
        }

        return result;
    }

    private void mergeSort(int[] nums, int[] smaller, int[] pos, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int[] merged = new int[end - start + 1];
        mergeSort(nums, smaller, pos, start, mid);
        mergeSort(nums, smaller, pos, mid + 1, end);
        int i = start, j = mid + 1, k = 0, jump = 0;
        while (i <= mid || j <= end) {
            if (i > mid) {
                merged[k++] = pos[j++];
            } else if (j > end) {
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else if (nums[pos[i]] <= nums[pos[j]]) {
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else {
                jump++;
                merged[k++] = pos[j++];
            }
        }
        for (int p = 0; p < merged.length; p++) {
            pos[start + p] = merged[p];
        }
    }
}
// @lc code=end

