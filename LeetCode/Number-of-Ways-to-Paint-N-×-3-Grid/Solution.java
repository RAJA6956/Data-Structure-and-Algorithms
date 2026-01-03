1class Solution {
2    public int numOfWays(int n) {
3        long MOD = 1_000_000_007;
4
5        long same = 6; // ABA patterns
6        long diff = 6; // ABC patterns
7
8        for (int i = 2; i <= n; i++) {
9            long newSame = (same * 3 + diff * 2) % MOD;
10            long newDiff = (same * 2 + diff * 2) % MOD;
11
12            same = newSame;
13            diff = newDiff;
14        }
15
16        return (int)((same + diff) % MOD);
17    }
18}
19