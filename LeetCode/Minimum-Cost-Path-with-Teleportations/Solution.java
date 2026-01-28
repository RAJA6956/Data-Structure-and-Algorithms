1class Solution {
2
3    public int minCost(int[][] grid, int k) {
4        int m = grid.length;
5        int n = grid[0].length;
6        List<int[]> points = new ArrayList<>();
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                points.add(new int[] { i, j });
10            }
11        }
12        points.sort(Comparator.comparingInt(p -> grid[p[0]][p[1]]));
13        int[][] costs = new int[m][n];
14        for (int[] row : costs) {
15            Arrays.fill(row, Integer.MAX_VALUE);
16        }
17        for (int t = 0; t <= k; t++) {
18            int minCost = Integer.MAX_VALUE;
19            for (int i = 0, j = 0; i < points.size(); i++) {
20                minCost = Math.min(
21                    minCost,
22                    costs[points.get(i)[0]][points.get(i)[1]]
23                );
24                if (
25                    i + 1 < points.size() &&
26                    grid[points.get(i)[0]][points.get(i)[1]] ==
27                    grid[points.get(i + 1)[0]][points.get(i + 1)[1]]
28                ) {
29                    continue;
30                }
31                for (int r = j; r <= i; r++) {
32                    costs[points.get(r)[0]][points.get(r)[1]] = minCost;
33                }
34                j = i + 1;
35            }
36            for (int i = m - 1; i >= 0; i--) {
37                for (int j = n - 1; j >= 0; j--) {
38                    if (i == m - 1 && j == n - 1) {
39                        costs[i][j] = 0;
40                        continue;
41                    }
42                    if (i != m - 1) {
43                        costs[i][j] = Math.min(
44                            costs[i][j],
45                            costs[i + 1][j] + grid[i + 1][j]
46                        );
47                    }
48                    if (j != n - 1) {
49                        costs[i][j] = Math.min(
50                            costs[i][j],
51                            costs[i][j + 1] + grid[i][j + 1]
52                        );
53                    }
54                }
55            }
56        }
57        return costs[0][0];
58    }
59}