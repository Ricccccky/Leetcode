import java.util.*;

/*
 * @lc app=leetcode id=2179 lang=java
 *
 * [2179] Count Good Triplets in an Array
 */

// @lc code=start
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        long result = 0;
        int n = nums1.length;
        int[] index = new int[n];
        long[] prefix = new long[n];
        long[] surfix = new long[n];
        List<Integer> buf = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            index[nums2[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            int pos = findInsert(buf, index[nums1[i]]);
            prefix[i] = pos;
            buf.add(pos, index[nums1[i]]);
        }
        buf.clear();
        for (int i = n - 1; i >= 0; i--) {
            int pos = findInsert(buf, index[nums1[i]]);
            surfix[i] = buf.size() - pos;
            buf.add(pos, index[nums1[i]]);
        }
        for (int i = 1; i < n; i++) {
            result += prefix[i] * surfix[i];
        }

        return result;
    }

    private int findInsert(List<Integer> list, int index) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < index) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
// @lc code=end

