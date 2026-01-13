1// this can be solved by backtracking 
2class Solution {
3    public boolean canPartitionKSubsets(int[] nums, int k) {
4        int totalSum = 0;
5        for (int x : nums) totalSum += x;
6        if (totalSum % k != 0) return false;
7        int target = totalSum / k;
8        boolean[] used = new boolean[nums.length];
9        return solve(nums, used, k, 0, 0, target);       
10    }
11
12    public boolean solve(int[] nums, boolean[] used, int k, int start, int currSum, int target) {
13        if (k == 1)
14        return true;
15        if (currSum == target)
16        return solve(nums, used, k - 1, 0, 0, target);
17        for (int i = start; i < nums.length; i++) {
18            if (used[i]) continue;
19            if (currSum + nums[i] > target) continue;
20            used[i] = true;
21            if (solve(nums, used, k, i + 1, currSum + nums[i], target))
22            return true;
23            //backtrack if found this way false;
24            used[i] = false; 
25    }
26    return false;
27}
28
29}
30