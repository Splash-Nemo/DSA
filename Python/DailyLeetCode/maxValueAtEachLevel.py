class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        q = deque([root])
        ans = []

        while q:
            n = len(q)
            max_val = float('-inf')

            for _ in range(n):
                node = q.popleft()
                max_val = max(max_val, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            ans.append(max_val)

        return ans
