# O(N^2)
class Solution:
    def singleNumber(self, nums: list[int]) -> int:
        for i in range(len(nums)):
            k = nums[i]
            boolValue = False

            for j in range(len(nums)):
                if i != j:
                    x = k ^ nums[j]
                    if x == 0:
                        boolValue = True
                        break

            if not boolValue:
                return k

        return -1

# O(N)
class Solution:
    def singleNumber(self, nums: list[int]) -> int:
        ans = 0
        for num in nums:
            ans ^= num
        return ans

