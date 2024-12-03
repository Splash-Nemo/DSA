class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        abc= set(spaces)
        
        ans= ""

        for i in range(len(s)):
            if i in abc:
                ans+= " "
            
            ans+= s[i]
        
        return ans