# O(N^2)
class Solution:
    def height(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        left = self.height(root.left)
        right = self.height(root.right)
        return max(left, right) + 1

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        l = self.height(root.left)
        r = self.height(root.right)
        if abs(l - r) > 1:
            return False
        left = self.isBalanced(root.left)
        right = self.isBalanced(root.right)
        return left and right

# O(N)

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.height(root) != -1

    def height(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        l = self.height(root.left)
        if l == -1:
            return -1
        r = self.height(root.right)
        if r == -1:
            return -1
        if abs(l - r) > 1:
            return -1
        return max(l, r) + 1
