1class Solution {
2
3    public int minimumDifference(int[] nums, int k) {
4        int n = nums.length;
5        Arrays.sort(nums);
6        int ans = Integer.MAX_VALUE;
7        for (int i = 0; i + k - 1 < n; ++i) {
8            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
9        }
10        return ans;
11    }
12}