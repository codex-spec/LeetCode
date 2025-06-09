class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA, headB):
        cur = headA
        curO = headB
        
        while cur != curO:
            cur = headB if cur is None else cur.next
            curO = headA if curO is None else curO.next
            
        return cur

