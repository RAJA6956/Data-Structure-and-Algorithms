1
2class Solution {
3    public int islandPerimeter(int[][] grid) {
4        int rows = grid.length;
5        int cols = grid[0].length;
6        for (int i = 0; i < rows; i++) {
7            for (int j = 0; j < cols; j++) {
8                if (grid[i][j] == 1) {
9                    return dfs(grid, i, j);
10                }
11            }
12        }
13        return 0;
14    }
15    private int dfs(int[][] grid, int r, int c) {
16        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
17            return 1;
18        }
19        if (grid[r][c] == 0) {
20            return 1;
21        }
22        if(grid[r][c]==-1) return 0;
23
24       
25        grid[r][c] = -1;
26        int perimeter = 0;
27        perimeter += dfs(grid, r + 1, c);
28        perimeter += dfs(grid, r - 1, c);
29        perimeter += dfs(grid, r, c + 1);
30        perimeter += dfs(grid, r, c - 1);
31
32        return perimeter;
33    }
34}
35