class Solution:
    def isPalindrome(self, s: str) -> bool:
        temp= ""

        for i in s:
            if i.isalnum():
                temp+= i.lower()
        if temp == temp[::-1]:
            return True
        else:
            return False
        