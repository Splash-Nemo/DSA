from typing import Optional

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def move(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return root
        
        self.move(root.left)
        self.move(root.right)

        temp= root.left
        root.left= root.right
        root.right= temp

        return root

    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        return self.move(root)