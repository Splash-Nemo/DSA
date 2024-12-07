class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        bset = set(i for i in banned if i <= n)
        
        total_sum = 0
        size = 0

        for i in range(1, n + 1):
            if i not in bset:
                total_sum += i
                if total_sum <= maxSum:
                    size += 1
                else:
                    break

        return size
