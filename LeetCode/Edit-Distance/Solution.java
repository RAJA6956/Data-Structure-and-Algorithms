1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length(), n = word2.length();
4        int[][] dp = new int[m + 1][n + 1];
5        for (int i = 1; i <= m; i++)
6            dp[i][0] = i;
7        for (int j = 1; j <= n; j++)
8            dp[0][j] = j;
9        for (int i = 1; i <= m; i++)
10            for (int j = 1; j <= n; j++)
11                if (word1.charAt(i - 1) == word2.charAt(j - 1))
12                    dp[i][j] = dp[i - 1][j - 1];
13                else
14                    dp[i][j] = Math.min(dp[i - 1][j - 1],
15                                Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
16        return dp[m][n];
17    }
18}