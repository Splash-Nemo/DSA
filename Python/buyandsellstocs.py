from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit= 0
        pointer= 0

        for i in range (1, len(prices)):
            if prices[i]>prices[pointer]:
                profit= max(profit, prices[i]-prices[pointer])
            else:
                pointer= i
        
        return profit
