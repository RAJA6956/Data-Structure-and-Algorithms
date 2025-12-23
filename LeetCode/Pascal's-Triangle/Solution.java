1// class Solution {
2//     int pascal(int r, int c) {
3//         if (c == 0 || c == r) return 1;
4//         return pascal(r - 1, c - 1) + pascal(r - 1, c);
5//     }
6
7//     public List<List<Integer>> generate(int numRows) {
8//         List<List<Integer>> result = new ArrayList<>();
9
10//         for (int r = 0; r < numRows; r++) {
11//             List<Integer> row = new ArrayList<>();
12//             for (int c = 0; c <= r; c++) {
13//                 row.add(pascal(r, c));   // recursive call
14//             }
15//             result.add(row);
16//         }
17
18//         return result;
19//     }
20// }
21
22
23// recursive call
24// class Solution {
25    
26//     public List<List<Integer>> generate(int numRows) {
27//         List<List<Integer>> result = new ArrayList<>();
28//         for(int i=0;i<numRows;i++){
29//             List<Integer> row = new ArrayList<>();
30//             for(int j=0;j<=i;j++){
31//                 row.add(solve(i,j));
32//             }
33//             result.add(row);
34//         }
35//         return result; 
36//     }
37
38//     public int solve(int i,int j){
39//         if(j==0 || j==i){
40//             return 1;
41//         } else{
42//             return solve(i-1,j-1)+solve(i-1,j);
43//         }
44//     }
45// }
46
47// Memoization
48// class Solution {
49    
50//     public List<List<Integer>> generate(int numRows) {
51//         List<List<Integer>> result = new ArrayList<>();
52//         int[][] dp=new int[numRows][numRows];
53        
54//         for (int i = 0; i < dp.length; i++) {
55//             Arrays.fill(dp[i],-1);
56//         }
57
58        
59//         for(int i=0;i<numRows;i++){
60//             List<Integer> row = new ArrayList<>();
61//             for(int j=0;j<=i;j++){
62//                 row.add(solve(i,j,dp));
63//             }
64//             result.add(row);
65//         }
66//         return result; 
67//     }
68
69//     public int solve(int i,int j,int[][] dp){
70//         if(j==0 || j==i){
71//             return 1;
72//         }
73//         if(dp[i][j] != -1) return dp[i][j];
74//         return dp[i][j] =solve(i-1,j-1,dp)+solve(i-1,j,dp);
75//     }
76// }
77
78//Tabulation
79
80class Solution {
81    
82    public List<List<Integer>> generate(int numRows) {
83        List<List<Integer>> result = new ArrayList<>();
84        int[][] dp=new int[numRows][numRows];
85        
86        for (int i = 0; i < dp.length; i++) {
87            Arrays.fill(dp[i],-1);
88        }
89
90        
91        for(int i=0;i<numRows;i++){
92            List<Integer> row = new ArrayList<>();
93            for(int j=0;j<=i;j++){
94                row.add(solve(i,j,dp));
95            }
96            result.add(row);
97        }
98        return result; 
99    }
100
101    public int solve(int i,int j,int[][] dp){
102        if(j==0 || j==i){
103            return 1;
104        }
105        if(dp[i][j] != -1) return dp[i][j];
106        return dp[i][j] =solve(i-1,j-1,dp)+solve(i-1,j,dp);
107    }
108}
109
110