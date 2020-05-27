#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        StrsLen = len(strs)
        if StrsLen == 0:
            return ''
        
        SortedStrs = sorted(strs, key=lambda x:len(x))
        prefix = SortedStrs[0]
        for i in range(1, StrsLen):
            while SortedStrs[i].find(prefix) != 0:
                prefix = prefix[:len(prefix) - 1]
                if prefix == '':
                    return prefix
        return prefix



