class Solution:
    def maxKDivisibleComponents(self, n: int, edges: list[list[int]], values: list[int], k: int) -> int:
        self.components = 0
        self.adjList = [[] for _ in range(n)]
        self.visited = [False] * n
        
        for edge in edges:
            self.adjList[edge[0]].append(edge[1])
            self.adjList[edge[1]].append(edge[0])
        
        self.dfs(0, values, k)
        return self.components

    def dfs(self, i: int, values: list[int], k: int) -> int:
        if self.visited[i]:
            return 0
        self.visited[i] = True
        valSum = values[i]
        
        for adjInd in self.adjList[i]:
            valSum += self.dfs(adjInd, values, k)
        
        if valSum % k == 0:
            self.components += 1
        
        return valSum
