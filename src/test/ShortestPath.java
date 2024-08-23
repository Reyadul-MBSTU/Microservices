package test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length - 1;

        if (grid[0][0] == 1 || grid[n][n] == 1)
            return -1;

        //BFS Queue
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                if (x == n && y == n) {
                    return level + 1;
                }

                if (x < 0 || y < 0 || x > n || y > n || grid[x][y] == 1 || grid[x][y] == 2) {
                    continue;
                }
                grid[x][y] = 2;

                q.offer(new Pair(x - 1, y - 1));
                q.offer(new Pair(x - 1, y));
                q.offer(new Pair(x - 1, y + 1));
                q.offer(new Pair(x, y - 1));
                q.offer(new Pair(x, y + 1));
                q.offer(new Pair(x + 1, y - 1));
                q.offer(new Pair(x + 1, y));
                q.offer(new Pair(x + 1, y + 1));

            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        ShortestPath shortestPath = new ShortestPath();
        int ans = shortestPath.shortestPathBinaryMatrix(grid);
        System.out.println(ans);
    }
}
