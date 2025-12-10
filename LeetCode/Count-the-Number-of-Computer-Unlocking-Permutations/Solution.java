1class Solution {
2
3    public int countPermutations(int[] complexity) {
4        int n = complexity.length;
5        for (int i = 1; i < n; i++) {
6            if (complexity[i] <= complexity[0]) {
7                return 0;
8            }
9        }
10
11        int ans = 1;
12        int mod = 1000000007;
13        for (int i = 2; i < n; i++) {
14            ans = (int) (((long) ans * i) % mod);
15        }
16        return ans;
17    }
18}