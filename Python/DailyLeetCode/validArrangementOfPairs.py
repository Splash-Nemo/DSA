from collections import defaultdict

class Solution:
    def __init__(self):
        self.adj = defaultdict(list)
        self.deg = defaultdict(int)
        self.rpath = []

    def build_graph(self, pairs):
        for start, end in pairs:
            self.adj[start].append(end)
            self.deg[start] += 1
            self.deg[end] -= 1

    def euler(self, start):
        stack = [start]
        while stack:
            node = stack[-1]
            if not self.adj[node]:
                self.rpath.append(node)
                stack.pop()
            else:
                next_node = self.adj[node].pop()
                stack.append(next_node)

    def validArrangement(self, pairs):
        self.build_graph(pairs)

        start = next(iter(self.deg))
        for node, degree in self.deg.items():
            if degree == 1:
                start = node
                break

        self.euler(start)

        ans = []
        for i in range(len(self.rpath) - 1, 0, -1):
            ans.append([self.rpath[i], self.rpath[i - 1]])

        return ans
