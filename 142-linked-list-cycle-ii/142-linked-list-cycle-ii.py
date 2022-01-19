# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None or head.next == None or head.next.next == None:
            return None
        
        slow , fast = head, head
        hasCycle = False
        
        while slow.next!=None and fast.next!= None and fast.next.next!=None:
            slow = slow.next
            fast = fast.next.next
            
            if slow == fast:
                hasCycle = True
                break
        if not hasCycle:
            return None
        fast =head
        while True:
            if fast == slow:
                return fast
            slow = slow.next
            fast = fast.next
        