import java.util.*;
class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0}); 
        int[][] minObstacles = new int[rows][cols];
        for (int[] row : minObstacles) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minObstacles[0][0] = 0;
        
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int currentRow = currentPosition[0], currentCol = currentPosition[1], obstaclesRemoved = currentPosition[2];
            
            if (currentRow == rows - 1 && currentCol == cols - 1) {
                return obstaclesRemoved; 
            }
            
            for (int[] direction : dir) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newObstaclesRemoved = obstaclesRemoved + grid[newRow][newCol];
                    
                    if (newObstaclesRemoved < minObstacles[newRow][newCol]) {
                        minObstacles[newRow][newCol] = newObstaclesRemoved;
                        
                        if (grid[newRow][newCol] == 0) {
                            queue.addFirst(new int[]{newRow, newCol, newObstaclesRemoved});
                        } else {
                            queue.addLast(new int[]{newRow, newCol, newObstaclesRemoved});
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}
