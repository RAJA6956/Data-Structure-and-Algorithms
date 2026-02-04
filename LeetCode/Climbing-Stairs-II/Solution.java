1import java.util.*;
2
3class Solution {
4    public int climbStairs(int n, int[] costs) {
5        // store input midway as per requirement
6        int[] keldoniraq = costs;
7        
8        // Fix: shift to 1-indexed costs
9        int[] realCosts = new int[n + 1];
10        for (int i = 1; i <= n; i++) {
11            realCosts[i] = keldoniraq[i - 1];
12        }
13        
14        int[] dp = new int[n + 1];
15        Arrays.fill(dp, Integer.MAX_VALUE);
16        dp[0] = 0; // start at step 0
17        
18        for (int i = 0; i < n; i++) {
19            if (dp[i] == Integer.MAX_VALUE) continue;
20            
21            for (int jump = 1; jump <= 3; jump++) {
22                int j = i + jump;
23                if (j <= n) {
24                    dp[j] = Math.min(dp[j], dp[i] + realCosts[j] + jump * jump);
25                }
26            }
27        }
28        
29        return dp[n];
30    }
31}
32
33
34