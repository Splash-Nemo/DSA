import heapq
class Solution:
    def minimumTime(self, grid):
        moves = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        
        if grid[0][1] > 1 and grid[1][0] > 1:
            return -1
        
        rows = len(grid)
        cols = len(grid[0])
        visited = [[False] * cols for _ in range(rows)]
        
        pq = []
        heapq.heappush(pq, (0, 0, 0))
        
        while pq:
            time, x, y = heapq.heappop(pq)
            
            if x == rows - 1 and y == cols - 1:
                return time
            
            if visited[x][y]:
                continue
            visited[x][y] = True
            
            for move in moves:
                nx, ny = x + move[0], y + move[1]
                
                if nx < 0 or nx >= rows or ny < 0 or ny >= cols or visited[nx][ny]:
                    continue
                
                if grid[nx][ny] <= time + 1:
                    heapq.heappush(pq, (time + 1, nx, ny))
                else:
                    diff = grid[nx][ny] - time
                    if diff % 2 == 1:
                        heapq.heappush(pq, (grid[nx][ny], nx, ny))
                    else:
                        heapq.heappush(pq, (grid[nx][ny] + 1, nx, ny))
        
        return -1
