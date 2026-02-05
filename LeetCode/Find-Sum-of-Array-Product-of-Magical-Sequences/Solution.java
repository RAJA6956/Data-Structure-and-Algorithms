1class Solution {
2    private static final int MOD = 1_000_000_007;
3
4    public int magicalSum(int m, int k, int[] nums) {
5        int n = nums.length;
6        // Precompute combinations C(m, j) for 0 ≤ j ≤ m
7        int[][] comb = getComb(m, m);
8
9        // Memoization: mem[mRemaining][kRemaining][iIndex][carry]
10        Integer[][][][] mem = new Integer[m + 1][k + 1][n + 1][m + 1];
11        return dp(m, k, 0, 0, nums, mem, comb);
12    }
13
14    private int dp(int mRem, int kRem, int i, int carry, int[] nums,
15                   Integer[][][][] mem, int[][] comb) {
16        // If invalid states
17        if (mRem < 0 || kRem < 0) return 0;
18        // Prune: even with all remaining picks you can't reach kRem
19        // Here carry’s bits represent bit-counts from lower bits
20        if (mRem + Integer.bitCount(carry) < kRem) return 0;
21
22        int n = nums.length;
23        if (mRem == 0) {
24            // Base: if no picks left, we must match exactly kRem = bitcount(carry)
25            return (kRem == Integer.bitCount(carry)) ? 1 : 0;
26        }
27        if (i == n) {
28            // No more nums to pick from
29            return 0;
30        }
31        if (mem[mRem][kRem][i][carry] != null) {
32            return mem[mRem][kRem][i][carry];
33        }
34
35        long res = 0;
36        // Try picking `count` times from nums[i], from 0 to mRem
37        for (int cnt = 0; cnt <= mRem; cnt++) {
38            long contribution = (long) comb[mRem][cnt] * modPow(nums[i], cnt) % MOD;
39            int newCarry = carry + cnt;  
40            // After adding cnt, the current LSB (newCarry % 2) contributes to kRem
41            int newK = kRem - (newCarry & 1);
42            int nextCarry = newCarry >>> 1;
43            int sub = dp(mRem - cnt, newK, i + 1, nextCarry, nums, mem, comb);
44            res = (res + sub * contribution) % MOD;
45        }
46
47        mem[mRem][kRem][i][carry] = (int) res;
48        return (int) res;
49    }
50
51    // Compute combinatorial table mod MOD (n choose k)
52    private int[][] getComb(int n, int k) {
53        int[][] comb = new int[n + 1][k + 1];
54        for (int i = 0; i <= n; i++) {
55            comb[i][0] = 1;
56        }
57        for (int i = 1; i <= n; i++) {
58            for (int j = 1; j <= k; j++) {
59                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
60            }
61        }
62        return comb;
63    }
64
65    private long modPow(long x, int exp) {
66        long ans = 1;
67        x %= MOD;
68        while (exp > 0) {
69            if ((exp & 1) == 1) {
70                ans = (ans * x) % MOD;
71            }
72            x = (x * x) % MOD;
73            exp >>= 1;
74        }
75        return ans;
76    }
77}
78