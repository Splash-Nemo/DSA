from collections import deque
from typing import List

class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])

        reachable = [[True] * cols for _ in range(rows)]
        reachable[0][0] = False

        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        queue = deque([(0, 0, 0)])
        while queue:
            current_row, current_col, current_distance = queue.popleft()

            for delta_row, delta_col in directions:
                next_row = current_row + delta_row
                next_col = current_col + delta_col

                if 0 <= next_row < rows and 0 <= next_col < cols and reachable[next_row][next_col]:
                    reachable[next_row][next_col] = False

                    if next_row == rows - 1 and next_col == cols - 1:
                        return current_distance
                    
                    if grid[next_row][next_col] == 0:
                        queue.appendleft((next_row, next_col, current_distance))
                    else:
                        queue.append((next_row, next_col, current_distance + 1))
