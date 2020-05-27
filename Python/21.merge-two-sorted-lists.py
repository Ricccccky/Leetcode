#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        Head = Dummy = ListNode(-1)
        while l1 and l2:
            if l1.val < l2.val:
                Head.next = l1
                l1 = l1.next
            else:
                Head.next = l2
                l2 = l2.next
            Head = Head.next
        if l1:
            Head.next = l1
        elif l2:
            Head.next = l2
        return Dummy.next

