1import java.util.*;
2
3class Solution {
4    static final class Event {
5        final long y;
6        final int l, r;
7        final int delta;
8        Event(long y, int l, int r, int delta) { this.y = y; this.l = l; this.r = r; this.delta = delta; }
9    }
10
11    static final class SegTree {
12        final long[] xs;
13        final long[] cover;
14        final int[] cnt;
15        SegTree(long[] xs) {
16            this.xs = xs;
17            int n = Math.max(1, xs.length - 1);
18            this.cover = new long[n << 2];
19            this.cnt = new int[n << 2];
20        }
21        long covered() { return cover[1]; }
22        void update(int l, int r, int delta) {
23            if (l >= r) return;
24            update(1, 0, xs.length - 1, l, r, delta);
25        }
26        private void update(int node, int L, int R, int ql, int qr, int delta) {
27            if (qr <= L || R <= ql) return;
28            if (ql <= L && R <= qr) {
29                cnt[node] += delta;
30                pushUp(node, L, R);
31                return;
32            }
33            int mid = (L + R) >>> 1;
34            update(node << 1, L, mid, ql, qr, delta);
35            update(node << 1 | 1, mid, R, ql, qr, delta);
36            pushUp(node, L, R);
37        }
38        private void pushUp(int node, int L, int R) {
39            if (cnt[node] > 0) {
40                cover[node] = xs[R] - xs[L];
41            } else if (L + 1 == R) {
42                cover[node] = 0;
43            } else {
44                cover[node] = cover[node << 1] + cover[node << 1 | 1];
45            }
46        }
47    }
48
49    public double separateSquares(int[][] squares) {
50        int n = squares.length;
51        if (n == 0) return -1;
52
53        long[] xs = new long[2 * n];
54        int p = 0;
55        for (int[] s : squares) {
56            long x1 = s[0];
57            long x2 = (long) s[0] + s[2];
58            xs[p++] = x1;
59            xs[p++] = x2;
60        }
61        Arrays.sort(xs);
62        int m = 1;
63        for (int i = 1; i < xs.length; i++) {
64            if (xs[i] != xs[m - 1]) xs[m++] = xs[i];
65        }
66        xs = Arrays.copyOf(xs, m);
67        if (xs.length < 2) {
68            long minY = Long.MAX_VALUE;
69            for (int[] s : squares) minY = Math.min(minY, (long) s[1]);
70            return (double) minY;
71        }
72
73        Event[] events = new Event[2 * n];
74        int e = 0;
75        for (int[] s : squares) {
76            long x1 = s[0];
77            long x2 = (long) s[0] + s[2];
78            long y1 = s[1];
79            long y2 = (long) s[1] + s[2];
80            int l = lowerBound(xs, x1);
81            int r = lowerBound(xs, x2);
82            if (l < r) {
83                events[e++] = new Event(y1, l, r, +1);
84                events[e++] = new Event(y2, l, r, -1);
85            }
86        }
87        if (e == 0) return -1;
88        events = Arrays.copyOf(events, e);
89        Arrays.sort(events, (a, b) -> Long.compare(a.y, b.y));
90
91        SegTree st = new SegTree(xs);
92
93        long[] sY = new long[e];
94        long[] eY = new long[e];
95        long[] base = new long[e];
96        int gi = 0;
97
98        long area = 0;
99        long prevY = events[0].y;
100        long baseLen = 0;
101        int i = 0;
102        while (i < e) {
103            long currY = events[i].y;
104            long dy = currY - prevY;
105            if (dy != 0 && baseLen != 0) {
106                area += baseLen * dy;
107                sY[gi] = prevY;
108                eY[gi] = currY;
109                base[gi] = baseLen;
110                gi++;
111            }
112            int j = i;
113            while (j < e && events[j].y == currY) {
114                st.update(events[j].l, events[j].r, events[j].delta);
115                j++;
116            }
117            baseLen = st.covered();
118            prevY = currY;
119            i = j;
120        }
121
122        if (area == 0) return prevY;
123        double target = area / 2.0;
124        long pref = 0;
125        for (int k = 0; k < gi; k++) {
126            long a = base[k] * (eY[k] - sY[k]);
127            if (pref + a < target) {
128                pref += a;
129            } else {
130                double remain = target - pref;
131                return sY[k] + remain / base[k];
132            }
133        }
134        return prevY;
135    }
136
137    private static int lowerBound(long[] a, long key) {
138        int lo = 0, hi = a.length;
139        while (lo < hi) {
140            int mid = (lo + hi) >>> 1;
141            if (a[mid] < key) lo = mid + 1;
142            else hi = mid;
143        }
144        return lo;
145    }
146}