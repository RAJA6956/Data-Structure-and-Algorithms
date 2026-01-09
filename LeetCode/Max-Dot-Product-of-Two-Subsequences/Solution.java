1class Solution {
2    public int maxDotProduct(int[] nums1, int[] nums2) {
3        int n = nums1.length, m = nums2.length;
4        int[][] dp = new int[n][m];
5
6        // Initialize with very small values
7        for (int i = 0; i < n; i++) {
8            for (int j = 0; j < m; j++) {
9                dp[i][j] = Integer.MIN_VALUE / 2;
10            }
11        }
12
13        for (int i = 0; i < n; i++) {
14            for (int j = 0; j < m; j++) {
15                int prod = nums1[i] * nums2[j];
16
17                dp[i][j] = prod;
18
19                if (i > 0 && j > 0)
20                    dp[i][j] = Math.max(dp[i][j], prod + dp[i-1][j-1]);
21
22                if (i > 0)
23                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
24
25                if (j > 0)
26                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
27            }
28        }
29
30        return dp[n - 1][m - 1];
31    }
32}
33