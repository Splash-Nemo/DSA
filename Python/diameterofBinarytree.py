class Solution:
    def __init__(self):
        self.ans = 0

    def height(self, root):
        if root is None:
            return 0

        left = self.height(root.left)
        right = self.height(root.right)

        self.ans = max(self.ans, left + right)

        return max(left, right) + 1

    def diameterOfBinaryTree(self, root):
        self.height(root)
        return self.ans
