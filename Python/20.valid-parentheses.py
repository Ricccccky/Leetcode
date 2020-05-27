#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#
class Solution:
    def isValid(self, s: str) -> bool:
        if str == '':
            return True
        if len(s) % 2 != 0:
            return False
        CharDict = {
            '(':1,
            ')':-1,
            '{':10,
            '}':-10,
            '[':100,
            ']':-100
        }

        Result = []
        for i in s:
            if CharDict[i] > 0:
                Result.append(i)
            elif CharDict[i] < 0:
                if len(Result) == 0:
                    return False
                LastChar = Result.pop()
                if CharDict[LastChar] + CharDict[i] != 0:
                    return False
        if len(Result) == 0:
            return True
        return False


