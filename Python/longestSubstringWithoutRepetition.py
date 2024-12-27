class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        ans = 1
        n = len(s)
        si, ei = 0, 0
        check = set()

        while ei < n and si <= ei:
            if s[ei] not in check:
                check.add(s[ei])
                ei += 1
            else:
                ans = max(ans, len(check))
                check.remove(s[si])
                si += 1

        return max(ans, len(check))
