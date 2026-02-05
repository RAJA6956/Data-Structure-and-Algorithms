1class Solution {
2    public int maxAreaOfIsland(int[][] grid) {
3        int Area_max=0;
4        for (int i=0; i<grid.length;i++) {
5            for (int j = 0; j < grid[0].length; j++) {
6                if (grid[i][j] == 1) {
7                    Area_max = Math.max(Area_max, dfs(grid, i, j));
8                }
9            }
10        }
11        return Area_max;
12    }
13    private int dfs(int[][] grid, int r, int c) {
14        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
15                || grid[r][c] == 0) {
16            return 0;
17        }
18        //mark the current island visited
19        grid[r][c] = 0;
20        return 1
21                + dfs(grid, r + 1, c)
22                + dfs(grid, r - 1, c)
23                + dfs(grid, r, c + 1)
24                + dfs(grid, r, c - 1);
25    }
26}
27