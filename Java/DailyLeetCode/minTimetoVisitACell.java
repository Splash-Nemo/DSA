import java.util.*;
class Solution {
    private int[][] moves = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[] { 0, 0, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
            if (x == rows - 1 && y == cols - 1) {
                return time;
            }
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            for (int[] move : moves) {
                int nx = x + move[0];
                int ny = y + move[1];
                if (nx < 0 || nx == rows || ny < 0 || ny == cols || visited[nx][ny]) {
                    continue;
                }

                if (grid[nx][ny] <= time + 1) {
                    queue.offer(new int[] { nx, ny, time + 1 });
                } else {
                    int diff = grid[nx][ny] - time;
                    if (diff % 2 == 1) {
                        queue.offer(new int[] { nx, ny, grid[nx][ny] });
                    } else {
                        queue.offer(new int[] { nx, ny, grid[nx][ny] + 1 });
                    }
                }
            }
        }
        return -1;
    }
}
