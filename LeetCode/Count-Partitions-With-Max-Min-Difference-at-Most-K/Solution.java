1import java.util.*;
2
3class Solution {
4    static final long MOD = 1000000007L;
5
6    public int countPartitions(int[] nums, int k) {
7        int n = nums.length;
8        long[] dp = new long[n + 1];
9        long[] prefix = new long[n + 2];
10
11        dp[0] = 1;
12        prefix[1] = 1;
13
14        Deque<Integer> minq = new ArrayDeque<>();
15        Deque<Integer> maxq = new ArrayDeque<>();
16
17        int j = 0;
18
19        for (int i = 0; i < n; i++) {
20            while (!maxq.isEmpty() && nums[i] > maxq.peekLast()) maxq.pollLast();
21            maxq.addLast(nums[i]);
22
23            while (!minq.isEmpty() && nums[i] < minq.peekLast()) minq.pollLast();
24            minq.addLast(nums[i]);
25
26            while (!maxq.isEmpty() && !minq.isEmpty() && maxq.peekFirst() - minq.peekFirst() > k) {
27                if (nums[j] == maxq.peekFirst()) maxq.pollFirst();
28                if (nums[j] == minq.peekFirst()) minq.pollFirst();
29                j++;
30            }
31
32            long total = (prefix[i + 1] - prefix[j] + MOD) % MOD;
33            dp[i + 1] = total;
34            prefix[i + 2] = (prefix[i + 1] + dp[i + 1]) % MOD;
35        }
36
37        return (int) dp[n];
38    }
39}