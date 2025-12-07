1/// bottom up approach - dp
2// class Solution {
3//     public int climbStairs(int n) {
4//         if(n<=1) return 1;
5//         int[] dp=new int[n+1];
6//         dp[0]=1;
7//         dp[1]=1;
8//         for(int i=2;i<=n;i++){
9//             dp[i]=dp[i-1] +dp[i-2];
10//         }
11//         return dp[n];
12//     }
13
14// }
15
16/// bottom up approach with space optimization
17class Solution {
18    public int climbStairs(int n) {
19        if(n<=1) return 1;
20        int first=1;
21        int second=1;
22        int ans=0;
23        for(int i=2;i<=n;i++){
24            ans=first+second;
25            second=first;
26            first=ans;
27
28        }
29        return ans;
30    }
31
32}
33
34