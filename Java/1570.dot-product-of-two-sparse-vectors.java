import java.util.*;

/*
 * @lc app=leetcode id=1570 lang=java
 *
 * [1570] Dot Product of Two Sparse Vectors
 */

// @lc code=start
class SparseVector {
    Map<Integer, Integer> vector;
    SparseVector(int[] nums) {
        vector = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                vector.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (var entry : vector.entrySet()) {
            if (vec.vector.containsKey(entry.getKey())) {
                result += entry.getValue() * vec.vector.get(entry.getKey());
            }
        }

        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
// @lc code=end

