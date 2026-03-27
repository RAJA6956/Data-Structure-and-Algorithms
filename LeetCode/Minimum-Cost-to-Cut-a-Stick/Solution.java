1class Solution {
2    int[][] dp;
3    int[] cuts;
4
5    public int minCost(int n, int[] cuts) {
6        Arrays.sort(cuts);
7        this.cuts = cuts;
8        dp = new int[cuts.length][cuts.length];
9        return cost(0, cuts.length - 1, 0, n);
10    }
11
12    private int cost(int i, int j, int start, int end) {
13        if (i > j) {
14            return 0; 
15        }
16        if (dp[i][j] != 0) {
17            return dp[i][j]; 
18        }
19        int minCost = Integer.MAX_VALUE;
20        for (int k = i; k <= j; k++) {
21            int fs = cost(i, k - 1, start, cuts[k]); 
22            int ss = cost(k + 1, j, cuts[k], end);   
23            int self = end - start;                  
24            minCost = Math.min(minCost, fs + ss + self);
25        }
26        return dp[i][j] = minCost;
27    }
28}