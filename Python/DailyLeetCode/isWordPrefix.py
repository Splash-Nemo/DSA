class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:

        if len(sentence)<len(searchWord):
            return -1
        
        abc= sentence.split(" ")
        n1= len(abc)
        n2= len(searchWord)

        count= 0

        for i in abc:
            count+=1
            if len(i)>=n2:
                if i.startswith(searchWord):
                    return count
        
        return -1
        