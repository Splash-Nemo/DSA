from typing import Optional
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p is None and q is not None or p is not None and q is None:
            return False
        elif p is None and q is None:
            return True
        elif p.val!=q.val:
            return False
        
        bool1= self.isSameTree(p.left, q.left)
        bool2= self.isSameTree(p.right, q.right)

        return bool1 and bool2
        