class Solution:
    def climbStairs(self, n: int) -> int:
        if n==0 or n==1 or n==2:
            return n
        
        arr= []
        arr.append(0)
        arr.append(1)
        arr.append(2)

        for i in range(3, n+1):
            temp= arr[i-1]+arr[i-2]
            arr.append(temp)
        
        return arr[n]
        
