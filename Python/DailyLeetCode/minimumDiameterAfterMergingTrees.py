class Solution:
    def __init__(self):
        self.maxD = -1

    def minimumDiameterAfterMerge(self, edges1, edges2):
        n1, n2 = len(edges1) + 1, len(edges2) + 1
        t1 = [[] for _ in range(n1)]
        t2 = [[] for _ in range(n2)]

        for e in edges1:
            t1[e[0]].append(e[1])
            t1[e[1]].append(e[0])
        for e in edges2:
            t2[e[0]].append(e[1])
            t2[e[1]].append(e[0])

        self.maxD = -1
        vis1 = [False] * n1
        self.calcDiam(0, t1, vis1)
        d1 = self.maxD

        self.maxD = -1
        vis2 = [False] * n2
        self.calcDiam(0, t2, vis2)
        d2 = self.maxD

        candDiam = (d1 + 1) // 2 + (d2 + 1) // 2 + 1
        return max(candDiam, max(d1, d2))

    def calcDiam(self, node, t, vis):
        vis[node] = True
        maxH, secMaxH = -1, -1

        for child in t[node]:
            if not vis[child]:
                h = self.calcDiam(child, t, vis)
                if h > maxH:
                    secMaxH, maxH = maxH, h
                elif h > secMaxH:
                    secMaxH = h

        self.maxD = max(self.maxD, maxH + secMaxH + 2)
        return maxH + 1
