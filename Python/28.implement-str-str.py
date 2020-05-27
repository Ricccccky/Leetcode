#
# @lc app=leetcode id=28 lang=python3
#
# [28] Implement strStr()
#

# @lc code=start
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        stackLen = len(haystack)
        needleLen = len(needle)

        next = [-1 for i in range(needleLen)]
        k = -1
        j = 0
        while (j < needleLen - 1):
            if (k == -1 or needle[j] == needle[k]):
                k += 1
                j += 1
                next[j] = k
            else:
                k = next[k]
        
        i = 0
        j = 0
        while (i < stackLen and j < needleLen):
            if (j == -1 or haystack[i] == needle[j]):
                i += 1
                j += 1
            else:
                j = next[j]
        if j == needleLen:
            return i - j
        else:
            return -1

# @lc code=end

