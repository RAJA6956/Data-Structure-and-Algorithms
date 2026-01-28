1import java.util.*;
2
3class Solution {
4    public int swimInWater(int[][] grid) {
5        int n = grid.length;
6        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
7        boolean[][] visited = new boolean[n][n];
8        
9        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
10        // pq stores {time, x, y}
11        pq.offer(new int[]{grid[0][0], 0, 0});
12        visited[0][0] = true;
13        
14        int ans = 0;
15        while (!pq.isEmpty()) {
16            int[] cur = pq.poll();
17            int t = cur[0], x = cur[1], y = cur[2];
18            ans = Math.max(ans, t);
19            
20            if (x == n - 1 && y == n - 1) return ans;
21            
22            for (int[] d : dirs) {
23                int nx = x + d[0], ny = y + d[1];
24                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
25                    visited[nx][ny] = true;
26                    pq.offer(new int[]{grid[nx][ny], nx, ny});
27                }
28            }
29        }
30        return ans;
31    }
32}
33