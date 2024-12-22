class Solution:
    def leftmostBuildingQueries(self, heights, queries):
        def next_greater(heights, n):
            next_greater = [-1] * n
            stack = []
            for i in range(n):
                while stack and heights[stack[-1]] < heights[i]:
                    j = stack.pop()
                    next_greater[j] = i
                stack.append(i)
            return next_greater

        n = len(heights)
        next_greater_list = next_greater(heights, n)
        
        m = len(queries)
        ans = [0] * m
        
        for i in range(m):
            max_idx = max(queries[i][0], queries[i][1])
            min_idx = min(queries[i][0], queries[i][1])
            
            if max_idx == min_idx:
                ans[i] = max_idx
                continue
            
            if heights[max_idx] > heights[min_idx]:
                ans[i] = max_idx
            else:
                if next_greater_list[max_idx] == -1:
                    ans[i] = -1
                else:
                    find = False
                    while not find:
                        next_idx = next_greater_list[max_idx]
                        if next_idx == -1:
                            ans[i] = -1
                            find = True
                        elif heights[next_idx] > heights[min_idx]:
                            ans[i] = next_idx
                            find = True
                        else:
                            max_idx = next_idx
        
        return ans
