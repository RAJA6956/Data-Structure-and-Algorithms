1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4        int[] minLen = new int[n];
5        Arrays.fill(minLen, Integer.MAX_VALUE);
6        Map<Integer, Integer> prefixMap = new HashMap<>();
7        prefixMap.put(0, -1);
8        int sum = 0, res = Integer.MAX_VALUE, best = Integer.MAX_VALUE;
9
10        for (int i = 0; i < n; i++) {
11            sum += arr[i];
12            if (prefixMap.containsKey(sum - target)) {
13                int start = prefixMap.get(sum - target) + 1;
14                int len = i - start + 1;
15                if (start > 0 && minLen[start - 1] != Integer.MAX_VALUE)
16                    res = Math.min(res, len + minLen[start - 1]);
17                best = Math.min(best, len);
18            }
19            minLen[i] = best;
20            prefixMap.put(sum, i);
21        }
22        return res == Integer.MAX_VALUE ? -1 : res;
23    }
24}
25