class Solution:
    def isHappy(self, n: int) -> bool:
        abc= set()

        while n!=1 and n not in abc:
            k= n
            digitSum= 0
            while k>0:
                digitSum+= math.pow(k%10,2)
                k//=10

            abc.add(n)
            n= digitSum
        
        return n==1