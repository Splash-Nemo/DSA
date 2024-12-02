from typing import Optional

class ListNode:
     def __init__(self, x):
         self.val = x
         self.next = None

# Using 2-pointers
class Solution1:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        
        if head is None or head.next is None or head.next.next is None:
            return False

        slow= head
        fast= head.next
        
        while(fast is not None and fast.next is not None and fast.next.next is not None):
            if slow== fast:
                return True

            slow= slow.next
            fast= fast.next.next
            
        
        return False
    
# Using Hashset
class Solution2:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        
        if head is None or head.next is None or head.next.next is None:
            return False
        
        abc= set()

        temp= head
        while temp is not None:
            if abc.__contains__(temp):
                return True
            abc.add(temp)
            temp= temp.next
        
        return False