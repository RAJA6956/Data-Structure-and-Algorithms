1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length(), n = p.length();
4        boolean[][] dp = new boolean[m + 1][n + 1];
5        dp[0][0] = true;
6
7        for (int j = 1; j <= n; j++)
8            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
9
10        for (int i = 1; i <= m; i++) {
11            for (int j = 1; j <= n; j++) {
12                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
13                if (pc == '?' || pc == sc)
14                    dp[i][j] = dp[i - 1][j - 1];
15                else if (pc == '*')
16                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
17            }
18        }
19        return dp[m][n];
20    }
21}
22