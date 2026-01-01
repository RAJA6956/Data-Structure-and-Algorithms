1import java.util.*;
2
3class Solution {
4    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
5
6    public int latestDayToCross(int row, int col, int[][] cells) {
7        int left = 1, right = cells.length;
8        int ans = 0;
9
10        while (left <= right) {
11            int mid = left + (right - left) / 2;
12            if (canCross(row, col, cells, mid)) {
13                ans = mid;      // possible → try later days
14                left = mid + 1;
15            } else {
16                right = mid - 1;
17            }
18        }
19        return ans;
20    }
21
22    private boolean canCross(int row, int col, int[][] cells, int day) {
23        int[][] grid = new int[row][col];
24
25        // Mark water cells
26        for (int i = 0; i < day; i++) {
27            int r = cells[i][0] - 1;
28            int c = cells[i][1] - 1;
29            grid[r][c] = 1; // water
30        }
31
32        Queue<int[]> q = new LinkedList<>();
33        boolean[][] vis = new boolean[row][col];
34
35        // Start BFS from top row land cells
36        for (int c = 0; c < col; c++) {
37            if (grid[0][c] == 0) {
38                q.offer(new int[]{0, c});
39                vis[0][c] = true;
40            }
41        }
42
43        while (!q.isEmpty()) {
44            int[] cur = q.poll();
45            int r = cur[0], c = cur[1];
46
47            if (r == row - 1) return true; // reached bottom
48
49            for (int[] d : dirs) {
50                int nr = r + d[0];
51                int nc = c + d[1];
52
53                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
54                    !vis[nr][nc] && grid[nr][nc] == 0) {
55
56                    vis[nr][nc] = true;
57                    q.offer(new int[]{nr, nc});
58                }
59            }
60        }
61
62        return false;
63    }
64}
65