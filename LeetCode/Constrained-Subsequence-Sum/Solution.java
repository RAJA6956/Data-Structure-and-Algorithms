1class Solution {
2    public int constrainedSubsetSum(int[] nums, int k) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        Deque<Integer> dq = new ArrayDeque<>();
6        int ans = nums[0];
7        for (int i = 0; i < n; i++) {
8            if (!dq.isEmpty() && dq.peekFirst() < i - k) dq.pollFirst();
9            dp[i] = nums[i] + (dq.isEmpty() ? 0 : Math.max(0, dp[dq.peekFirst()]));
10            ans = Math.max(ans, dp[i]);
11            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) dq.pollLast();
12            dq.offerLast(i);
13        }
14        return ans;
15    }
16}
17