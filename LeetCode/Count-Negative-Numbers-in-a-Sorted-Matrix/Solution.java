1class Solution {
2    public int countNegatives(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int row = 0, col = n - 1;
6        int count = 0;
7
8        while (row < m && col >= 0) {
9            if (grid[row][col] < 0) {
10                count += (m - row);
11                col--;
12            } else {
13                row++;
14            }
15        }
16
17        return count;
18    }
19}
20