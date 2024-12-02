from typing import List
class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        abc = dict()

        for i in range(len(arr)):
            abc[arr[i]] = i
        
        for i in range(len(arr)):
            temp = 2 * arr[i]
            
            if temp in abc and abc[temp] != i:
                return True
        
        return False
