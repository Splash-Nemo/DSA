from collections import defaultdict

class Solution:
    def shortestDistanceAfterQueries(self, n, queries):
        graph = defaultdict(list)
        distances = list(range(n))
        result = []

        for i in range(1, n):
            graph[i].append(i - 1)

        def update_distances(node):
            new_dist = distances[node] + 1
            for neighbor in graph[node]:
                if distances[neighbor] <= new_dist:
                    continue
                distances[neighbor] = new_dist
                update_distances(neighbor)

        for source, target in queries:
            graph[target].append(source)
            distances[source] = min(distances[source], distances[target] + 1)
            update_distances(source)
            result.append(distances[0])

        return result