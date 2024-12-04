class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        i, j = 0, 0

        while i < len(str1) and j < len(str2):
            if (ord(str1[i]) - ord('a') == ord(str2[j]) - ord('a') or 
               (ord(str1[i]) - ord('a') + 1) % 26 == ord(str2[j]) - ord('a')):
                j += 1
            i += 1

        return j == len(str2)
