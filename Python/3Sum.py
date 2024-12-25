from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans = []
        check = set()
        
        nums.sort()
        target = 0

        for i in range(len(nums)):
            tar = target - nums[i]
            si, ei = i + 1, len(nums) - 1

            while si < ei:
                if nums[si] + nums[ei] > tar:
                    ei -= 1
                elif nums[si] + nums[ei] < tar:
                    si += 1
                else:
                    triplet = (nums[si], nums[ei], nums[i])
                    if triplet not in check:
                        check.add(triplet)
                        ans.append([nums[si], nums[ei], nums[i]])
                    si += 1
                    ei -= 1

        return ans
