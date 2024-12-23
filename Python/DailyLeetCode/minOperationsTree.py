from typing import Optional, List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def moves(self, a: List[int], b: List[int]) -> int:
        move = 0
        for i in range(len(a)):
            ele = b[i]
            if a[i] == ele:
                continue
            for j in range(i, len(a)):
                if a[j] == ele:
                    break
            a[j] = a[i]
            move += 1
        return move

    def levelOrder(self, root: TreeNode) -> int:
        q = deque([root])
        ans = 0
        while q:
            n = len(q)
            arr = []
            arr2 = []
            for _ in range(n):
                ele = q.popleft()
                if ele.left:
                    q.append(ele.left)
                if ele.right:
                    q.append(ele.right)
                arr.append(ele.val)
                arr2.append(ele.val)
            arr2.sort()
            ans += self.moves(arr, arr2)
        return ans

    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        return self.levelOrder(root)
