1public class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length();
4        int n = p.length();
5        boolean[][] dp = new boolean[m + 1][n + 1];
6
7        // Base case: empty string matches empty pattern
8        dp[0][0] = true;
9
10        // Handle patterns like a*, a*b*, a*b*c* that can match empty string
11        for (int j = 2; j <= n; j++) {
12            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
13                dp[0][j] = true;
14            }
15        }
16
17        // Build the DP table
18        for (int i = 1; i <= m; i++) {
19            for (int j = 1; j <= n; j++) {
20                char sc = s.charAt(i - 1);
21                char pc = p.charAt(j - 1);
22
23                if (pc == '.' || pc == sc) {
24                    dp[i][j] = dp[i - 1][j - 1];
25                } else if (pc == '*') {
26                    char prev = p.charAt(j - 2);
27
28                    // Zero occurrence of the preceding character
29                    dp[i][j] = dp[i][j - 2];
30
31                    // One or more occurrences of the preceding character
32                    if (prev == '.' || prev == sc) {
33                        dp[i][j] |= dp[i - 1][j];
34                    }
35                }
36            }
37        }
38
39        return dp[m][n];
40    }
41}
42