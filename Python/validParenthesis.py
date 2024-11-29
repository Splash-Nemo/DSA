class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 1 or s[0] in ') } ]':
            return False
        
        stack = []
        
        for c in s:
            if c in '({[':
                stack.append(c)
            elif c in ')}]':
                if stack:
                    top = stack[-1]
                    if (top == '(' and c == ')') or (top == '{' and c == '}') or (top == '[' and c == ']'):
                        stack.pop()
                    else:
                        return False
                else:
                    return False
        
        return not stack
