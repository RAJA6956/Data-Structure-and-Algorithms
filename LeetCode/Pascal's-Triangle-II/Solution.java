1//recursive approach -TLE
2// 
3class Solution {
4    public List<Integer> getRow(int rowIndex) {
5        int[][] dp=new int[rowIndex+1][rowIndex+1];
6        for(int i=0;i<=rowIndex;i++){
7            Arrays.fill(dp[i],-1);
8        }
9        List<List<Integer>> curr=new ArrayList<>();
10        for(int i=0;i<= rowIndex;i++){
11            List<Integer> temp=new ArrayList<>();
12            for(int j=0;j<=i;j++){
13                temp.add(solve(i,j,dp));
14            }
15            curr.add(temp);
16        }
17        return curr.get(rowIndex);
18
19        
20    }
21    public int solve(int i,int j,int[][] dp){
22        if(j==0|| j==i) return 1;
23        if(dp[i][j] != -1) return dp[i][j];
24        return dp[i][j] = solve(i-1,j,dp) + solve(i-1,j-1,dp);
25
26    }
27}