from typing import Optional
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    
    def isSame(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None and subRoot is None:
            return True
        elif root is None or subRoot is None or root.val!=subRoot.val:
            return False
        
        if self.isSame(root.left, subRoot.left) is False:
            return False
        
        if self.isSame(root.right, subRoot.right) is False:
            return False
        
        return True

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        if root is None:
            return False
        
        if root.val==subRoot.val:
            if self.isSame(root, subRoot) is True:
                return True
        
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)