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
19// class Solution {
20//     public int rob(int[] nums) {
21//         int dp[]=new int[nums.length];
22//         Arrays.fill(dp,-1);
23//         return solve(0, nums,dp);
24//     }
25
26//     private int solve(int i, int[] nums,int dp[]) {
27//         if (i >= nums.length) return 0;
28//         if(dp[i] != -1){
29//             return dp[i];
30//         }
31//         // rob this index
32//         int rob = nums[i] + solve(i + 2, nums,dp);
33//         //skip this index
34//         int skip = solve(i + 1, nums,dp);
35//         return dp[i] = Math.max(rob, skip);
36//     }
37// }
38
39// tabulation-bottom up approach
40
41class Solution {
42    public int rob(int[] nums) {
43        if(nums.length==1) return nums[0];
44        if(nums.length==2) {
45            return Math.max(nums[0],nums[1]);
46        }
47
48        int dp[]=new int[nums.length];
49        return solve(0, nums,dp);
50    }
51
52    private int solve(int i, int[] nums,int dp[]) {
53        if (i >= nums.length) return 0;
54        dp[0]=nums[0];
55        dp[1]=Math.max(nums[0],nums[1]);
56        for(int x=2;x<nums.length;x++){
57            int rob = nums[x] + dp[x-2];
58            int skip=dp[x-1];
59            dp[x]=Math.max(rob,skip);
60        }
61        return dp[nums.length-1];
62        
63    }
64}