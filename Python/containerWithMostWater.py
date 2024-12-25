class Solution:
    def maxArea(self, height: List[int]) -> int:
        ans = 0
        si, ei = 0, len(height) - 1

        while si < ei:
            k = min(height[si], height[ei]) * (ei - si)
            ans = max(ans, k)

            if height[si] < height[ei]:
                si += 1
            elif height[si] > height[ei]:
                ei -= 1
            else:
                si += 1
                ei -= 1

        return ans
