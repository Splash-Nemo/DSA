class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        check = defaultdict(list)

        for s in strs:
            temp = ''.join(sorted(s))
            check[temp].append(s)
        
        return list(check.values())
