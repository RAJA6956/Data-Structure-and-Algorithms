1class Solution {
2    public long maximumScore(int[][] grid) {
3
4        int n = grid.length;
5        int m = grid[0].length;
6        if (m == 1) return 0;
7
8        long[][] col = new long[m][n + 1];
9
10        // prefix sum per column
11        for (int j = 0; j < m; j++) {
12            for (int i = 0; i < n; i++) {
13                col[j][i + 1] = col[j][i] + grid[i][j];
14            }
15        }
16
17        long[][] dp = new long[n + 1][n + 1];
18        long[][] prefMax = new long[n + 1][n + 1];
19        long[][] suffMax = new long[n + 1][n + 1];
20
21        for (int c = 1; c < m; c++) {
22
23            long[][] newdp = new long[n + 1][n + 1];
24
25            for (int curr = 0; curr <= n; curr++) {
26                for (int prev = 0; prev <= n; prev++) {
27
28                    if (curr <= prev) {
29                        long gain = col[c][prev] - col[c][curr];
30
31                        newdp[curr][prev] = Math.max(
32                                newdp[curr][prev],
33                                suffMax[prev][0] + gain
34                        );
35                    } else {
36                        long gain = col[c - 1][curr] - col[c - 1][prev];
37
38                        newdp[curr][prev] = Math.max(
39                                newdp[curr][prev],
40                                Math.max(
41                                        suffMax[prev][curr],
42                                        prefMax[prev][curr] + gain
43                                )
44                        );
45                    }
46                }
47            }
48
49            // build prefix & suffix
50            for (int curr = 0; curr <= n; curr++) {
51
52                prefMax[curr][0] = newdp[curr][0];
53
54                for (int prev = 1; prev <= n; prev++) {
55
56                    long penalty = 0;
57                    if (prev > curr)
58                        penalty = col[c][prev] - col[c][curr];
59
60                    prefMax[curr][prev] = Math.max(
61                            prefMax[curr][prev - 1],
62                            newdp[curr][prev] - penalty
63                    );
64                }
65
66                suffMax[curr][n] = newdp[curr][n];
67
68                for (int prev = n - 1; prev >= 0; prev--) {
69                    suffMax[curr][prev] = Math.max(
70                            suffMax[curr][prev + 1],
71                            newdp[curr][prev]
72                    );
73                }
74            }
75
76            dp = newdp;
77        }
78
79        long ans = 0;
80        for (int k = 0; k <= n; k++) {
81            ans = Math.max(ans, Math.max(dp[0][k], dp[n][k]));
82        }
83
84        return ans;
85    }
86}