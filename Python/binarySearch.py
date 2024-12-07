class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n= len(nums)
        si=0
        ei= n-1

        while si<=ei:
            mid= si+(ei-si)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                si= mid+1
            else:
                ei=mid-1
        
        return -1
        