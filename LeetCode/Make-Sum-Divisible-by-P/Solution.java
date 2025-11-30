1class Solution {
2  public int minSubarray(int[] nums, int p) {
3    final long sum = Arrays.stream(nums).asLongStream().sum();
4    final int remainder = (int) (sum % p);
5    if (remainder == 0)
6      return 0;
7    int ans = nums.length;
8    int prefix = 0;
9    Map<Integer, Integer> prefixToIndex = new HashMap<>();
10    prefixToIndex.put(0, -1);
11    for (int i = 0; i < nums.length; ++i) {
12      prefix += nums[i];
13      prefix %= p;
14      final int target = (prefix - remainder + p) % p;
15      if (prefixToIndex.containsKey(target))
16        ans = Math.min(ans, i - prefixToIndex.get(target));
17      prefixToIndex.put(prefix, i);
18    }
19    return ans == nums.length ? -1 : ans;
20  }
21}