from typing import Optional

class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        if head is None:
            return None
        
        if head.next is None:
            return head
        
        temp= head
        prev= None
        after= temp.next

        while (temp!=None):
            temp.next= prev
            prev= temp
            temp= after
            
            if after!=None:
                after= after.next
        
        return prev