1import java.util.Arrays;
2
3class Solution {
4    public int maxPathScore(int[][] grid, int k) {
5        int m = grid.length;
6        int n = grid[0].length;
7        final int NEG = -1_000_000_000;
8
9        int[][] prev = new int[n][k + 1];
10        for (int j = 0; j < n; j++) {
11            Arrays.fill(prev[j], NEG);
12        }
13
14        for (int i = 0; i < m; i++) {
15            int[][] curr = new int[n][k + 1];
16            for (int j = 0; j < n; j++) {
17                Arrays.fill(curr[j], NEG);
18            }
19
20            for (int j = 0; j < n; j++) {
21                int gain = grid[i][j];
22                int need = gain > 0 ? 1 : 0;
23
24                int limit = Math.min(k, i + j);
25
26                if (i == 0 && j == 0) {
27                    curr[0][0] = 0;
28                    continue;
29                }
30
31                for (int c = need; c <= limit; c++) {
32                    int best = NEG;
33
34                    if (i > 0 && prev[j][c - need] != NEG) {
35                        best = Math.max(best, prev[j][c - need] + gain);
36                    }
37
38                    if (j > 0 && curr[j - 1][c - need] != NEG) {
39                        best = Math.max(best, curr[j - 1][c - need] + gain);
40                    }
41
42                    curr[j][c] = best;
43                }
44            }
45
46            prev = curr;
47        }
48
49        int ans = NEG;
50        for (int c = 0; c <= k; c++) {
51            ans = Math.max(ans, prev[n - 1][c]);
52        }
53
54        return ans < 0 ? -1 : ans;
55    }
56}