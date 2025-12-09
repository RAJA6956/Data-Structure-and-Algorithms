1// class Solution {
2//     public int uniquePaths(int m, int n) {
3//         long res = 1;
4//         int k = Math.min(m - 1, n - 1); // choose smaller
5//         int total = m + n - 2;
6        
7//         for (int i = 1; i <= k; i++) {
8//             res = res * (total - k + i) / i;
9//         }
10//         return (int) res;
11//     }
12// }
13
14
15//Recursive Approach-tle
16// class Solution {
17
18//     public int uniquePaths(int m, int n) {
19//         return solve(m-1,n-1);
20        
21//     }
22//     public int solve(int i,int j){
23//         if(i<0 || j<0) return 0;
24//         if(i==0 && j==0) return 1;
25//         //if comes from uppper cell
26//         int up=solve(i-1,j);
27//         //if comes from left
28//         int left=solve(i,j-1);
29//         return up + left;
30//     }
31// }
32
33
34
35//Memoization
36class Solution {
37
38    public int uniquePaths(int m, int n) {
39        int[][] dp=new int[m+1][n+1];
40        for(int i=0;i<m+1;i++){
41            Arrays.fill(dp[i],-1);
42
43        }
44        return solve(m-1,n-1,dp);
45        
46    }
47    public int solve(int i,int j,int[][] dp){
48        if(i<0 || j<0) return 0;
49        if(i==0 && j==0) return 1;
50        if(dp[i][j] != -1){
51            return dp[i][j];
52        }
53        //if comes from uppper cell
54        int up=solve(i-1,j,dp);
55        //if comes from left
56        int left=solve(i,j-1,dp);
57        return dp[i][j]=up + left;
58    }
59}