1class Solution {
2    private String s;
3    private Map<String, long[]> mp = new HashMap<>();
4
5    private long[] dfs(int i, int a, int b, int t, int st, int len) {
6        if (i == s.length()) return new long[]{1, 0};
7
8        String key = i + "," + a + "," + b + "," + t + "," + st + "," + len;
9        if (mp.containsKey(key)) return mp.get(key);
10
11        long cnt = 0, wav = 0;
12
13        int limit = t == 1 ? (s.charAt(i) - '0') : 9;
14        for (int d = 0; d <= limit; d++) {
15            long[] res = dfs(i + 1, b, d,
16                t == 1 && d == (s.charAt(i) - '0') ? 1 : 0,
17                (st == 1 || d > 0) ? 1 : 0,
18                (st == 1 || d > 0) ? len + 1 : 0);
19
20            long c = res[0], w = res[1];
21            if (len > 1 && ((a < b && b > d) || (a > b && b < d))) w += c;
22
23            cnt += c;
24            wav += w;
25        }
26
27        long[] ans = {cnt, wav};
28        mp.put(key, ans);
29        return ans;
30    }
31
32    private long solve(long n) {
33        s = Long.toString(n);
34        mp.clear();
35        return dfs(0, 0, 0, 1, 0, 0)[1];
36    }
37
38    public long totalWaviness(long l, long r) {
39        return solve(r) - solve(l - 1);
40    }
41}