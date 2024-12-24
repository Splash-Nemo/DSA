class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        size = 0
        check = set(nums)

        for num in nums:
            if num - 1 not in check:
                count = 0
                curr = num + 1
                while curr in check:
                    count += 1
                    curr += 1
                size = max(count, size)

        return size + 1
