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
17// class Solution {
18//     public int climbStairs(int n) {
19//         if(n<=1) return 1;
20//         int first=1;
21//         int second=1;
22//         int ans=0;
23//         for(int i=2;i<=n;i++){
24//             ans=first+second;
25//             second=first;
26//             first=ans;
27
28//         }
29//         return ans;
30//     }
31
32// }
33
34
35
36/// write top down - memorization approach
37// class Solution {
38    
39
40//     public int climbStairs(int n) {
41//         int[] dp=new int[n+1];
42//         Arrays.fill(dp,-1);
43//         return solve(dp,n);
44//     }
45//     public int solve(int[] dp,int n){
46//         if(n<=1) return 1;
47//         if(dp[n] != -1) return dp[n];
48        
49
50//         return dp[n] = solve(dp,n-2) + solve(dp,n-1);
51//     }
52// }
53
54// Recursive approach
55// class Solution {
56
57//     public int climbStairs(int n) {
58//         if(n<=1) return 1;
59//         int two=climbStairs(n-2);
60//         int one=climbStairs(n-1);
61//         return one+two;
62//     }
63// }
64
65// Tabulation
66// class Solution {
67    
68
69//     public int climbStairs(int n) {
70//         int[] dp=new int[n+1];
71//         dp[0]=1;
72//         dp[1]=1;
73//         for(int i =2; i<=n;i++){
74//             dp[i] = dp[i-1]+dp[i-2];
75//         }
76//         return dp[n];
77    
78//     }
79// }
80//space optimized
81class Solution {
82    
83
84    public int climbStairs(int n) {
85        
86        int first =1;
87        int second=1;
88        int curr;
89        if(n<=1){
90            curr=1;
91        }else {
92            curr = 0;
93        }
94        for(int i=2;i<=n;i++){
95            curr = first + second;
96            first = second;
97            second = curr;
98
99
100        }
101        return curr;
102    }
103
104}
105