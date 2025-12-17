1// binary search on answer approach- tc= 
2// take low as 1 and high as maximum value and let mid is the required answer. on mid chec use recursive function to check wheather it satisfy the conditions or not.
3// also apply memoization on this approach
4// class Solution {
5//     public int calculateMinimumHP(int[][] dungeon) {
6//         int low = 1;
7//         int high =  (int)1e7;
8//         int minHealth = high;
9
10//         while(low <= high){
11//             int mid = low + (high - low)/2;
12//             if(survive(0,0,mid,dungeon)){
13//                 minHealth = mid;
14//                 high = mid - 1;
15//             }else{
16//                 low = mid + 1;
17//             }
18//         }
19//         return minHealth;
20//     }
21//     public boolean survive(int i, int j, int mid, int[][]dungeon){
22//         int m = dungeon.length;
23//         int n = dungeon[0].length;
24
25//         if(i >= m || j >= n){
26//             return false; 
27//         }
28
29//         mid+=dungeon[i][j];
30//         if(mid <= 0){
31//             return false;
32//         }
33//         if(i == m-1 && j == n-1){
34//             return true;
35//         }
36//         return survive(i + 1, j, mid, dungeon) || 
37//         survive(i, j + 1, mid, dungeon);
38//     }
39// }
40
41
42//recursive approach 
43// class Solution {
44//     int m;
45//     int n;
46//     public int calculateMinimumHP(int[][] dungeon) {
47//         m = dungeon.length;
48//         n = dungeon[0].length;
49
50//         return dfs(0, 0,dungeon);
51//     }
52
53//     private int dfs(int i, int j,int [][] dungeon) {
54//         //if go out of bound, return maximum value, so it gets rejected
55//         if (i >= m || j >= n)
56//             return Integer.MAX_VALUE;
57//         //if reach destination, 
58//         if (i == m - 1 && j == n - 1)
59//             return Math.max(1, 1 - dungeon[i][j]);
60
61//         int right = dfs(i, j + 1,dungeon);
62//         int down = dfs(i + 1, j,dungeon);
63
64//         int minNext = Math.min(right, down);
65
66//         return Math.max(1, minNext - dungeon[i][j]);
67//     }
68// }
69
70
71
72
73///memoization approach- start from 0,0 and go to m-1,n-1
74
75// class Solution {
76//     int m, n;
77//     int[][] memo;
78//     public int calculateMinimumHP(int[][] dungeon) {
79//         m = dungeon.length;
80//         n = dungeon[0].length;
81//         memo = new int[m][n];
82//         return dfs(0, 0, dungeon);
83//     }
84//     int dfs(int i, int j, int[][] dungeon) {
85//         if (i >= m || j >= n) {
86//             return Integer.MAX_VALUE;
87//         }
88//         if (memo[i][j] != 0) {
89//             return memo[i][j];
90//         }
91//         if (i == m - 1 && j == n - 1) {
92//             return memo[i][j] = Math.max(1, 1 - dungeon[i][j]);
93//         }
94//         int right = dfs(i, j + 1, dungeon);
95//         int down  = dfs(i + 1, j, dungeon);
96//         int minNext = Math.min(right, down);
97//         memo[i][j] = Math.max(1, minNext - dungeon[i][j]);
98//         return memo[i][j];
99//     }
100// }
101
102/// atbulatio Approach or bOTom up approach
103 class Solution {
104    public int calculateMinimumHP(int[][] dungeon) {
105        int m = dungeon.length;
106        int n = dungeon[0].length;
107
108        int[][] dp = new int[m][n];
109
110        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
111
112        for (int j = n - 2; j >= 0; j--) {
113            dp[m-1][j] = Math.max(
114                1,
115                dp[m-1][j + 1] - dungeon[m-1][j]
116            );
117        }
118
119        for (int i = m - 2; i >= 0; i--) {
120            dp[i][n-1] = Math.max(
121                1,
122                dp[i + 1][n-1] - dungeon[i][n-1]
123            );
124        }
125
126        // Fill remaining cells
127        for (int i = m - 2; i >= 0; i--) {
128            for (int j = n - 2; j >= 0; j--) {
129                int minNext = Math.min(dp[i + 1][j], dp[i][j + 1]);
130                dp[i][j] = Math.max(1, minNext - dungeon[i][j]);
131            }
132        }
133
134        return dp[0][0];
135    }
136}
137