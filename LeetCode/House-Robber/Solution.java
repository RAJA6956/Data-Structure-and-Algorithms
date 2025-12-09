1// recursion approach-tle
2// class Solution {
3//     public int rob(int[] nums) {
4//         return solve(0, nums);
5//     }
6
7//     private int solve(int i, int[] nums) {
8//         if (i >= nums.length) return 0;
9//         // rob this index
10//         int rob = nums[i] + solve(i + 2, nums);
11//         //skip this index
12//         int skip = solve(i + 1, nums);
13//         return Math.max(rob, skip);
14//     }
15// }
16
17
18// memoization
19class Solution {
20    public int rob(int[] nums) {
21        int dp[]=new int[nums.length];
22        Arrays.fill(dp,-1);
23        return solve(0, nums,dp);
24    }
25
26    private int solve(int i, int[] nums,int dp[]) {
27        if (i >= nums.length) return 0;
28        if(dp[i] != -1){
29            return dp[i];
30        }
31        // rob this index
32        int rob = nums[i] + solve(i + 2, nums,dp);
33        //skip this index
34        int skip = solve(i + 1, nums,dp);
35        return dp[i] = Math.max(rob, skip);
36    }
37}