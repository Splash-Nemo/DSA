class Solution:
    def minimumSize(self, nums: list[int], maxOperations: int) -> int:
        left = 1
        right = max(nums)

        while left < right:
            mid = left + (right - left) // 2
            if self.split(nums, maxOperations, mid):
                right = mid
            else:
                left = mid + 1

        return left

    def split(self, nums: list[int], maxOperations: int, maxBalls: int) -> bool:
        operations = 0
        for balls in nums:
            if balls > maxBalls:
                operations += (balls - 1) // maxBalls
            if operations > maxOperations:
                return False
        return True
