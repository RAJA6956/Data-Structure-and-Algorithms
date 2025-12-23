1class Solution {
2    static final int MOD=1_000_000_007;
3
4    public int rearrangeSticks(int n, int k) {
5        long[][] dp=new long[n+1][k+1];
6        dp[0][0]=1;
7
8        for(int i=1;i<=n;i++){
9            for(int j=1;j<=Math.min(i,k);j++){
10                dp[i][j] =(dp[i-1][j-1]+(i-1)*dp[i-1][j])%MOD;
11            }
12        }
13        return (int) dp[n][k];
14
15        
16    }
17}