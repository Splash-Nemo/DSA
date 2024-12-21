# Using Linked List
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        abc = ListNode(digits[-1])
        temp = abc

        for i in range(n - 2, -1, -1):
            new_node = ListNode(digits[i])
            temp.next = new_node
            temp = new_node

        temp = abc
        carry = 1
        size = n

        while carry == 1:
            temp.val += carry
            if temp.val >= 10:
                carry = 1
                temp.val %= 10
            else:
                carry = 0
            if temp.next:
                temp = temp.next
            else:
                break

        if carry == 1:
            new_node = ListNode(1)
            temp.next = new_node
            temp = new_node
            size += 1

        ans = [0] * size
        i = size - 1
        while abc:
            ans[i] = abc.val
            abc = abc.next
            i -= 1

        return ans

#Using math
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)

        for i in range(n - 1, -1, -1):
            if digits[i] + 1 != 10:
                digits[i] += 1
                return digits
            digits[i] = 0

        ans = [1] + [0] * n
        return ans
