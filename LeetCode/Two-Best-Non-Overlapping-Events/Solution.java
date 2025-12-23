1import java.util.*;
2
3class Solution {
4    public int maxTwoEvents(int[][] events) {
5        // sort by end time
6        Arrays.sort(events, (a, b) -> a[1] - b[1]);
7
8        int n = events.length;
9        int[] maxTill = new int[n];
10        maxTill[0] = events[0][2];
11
12        // prefix max of values
13        for (int i = 1; i < n; i++) {
14            maxTill[i] = Math.max(maxTill[i - 1], events[i][2]);
15        }
16
17        int ans = 0;
18
19        for (int i = 0; i < n; i++) {
20            int value = events[i][2];
21
22            // binary search for last event ending before start
23            int lo = 0, hi = i - 1;
24            int idx = -1;
25
26            while (lo <= hi) {
27                int mid = (lo + hi) / 2;
28                if (events[mid][1] < events[i][0]) {
29                    idx = mid;
30                    lo = mid + 1;
31                } else {
32                    hi = mid - 1;
33                }
34            }
35
36            if (idx != -1) {
37                value += maxTill[idx];
38            }
39
40            ans = Math.max(ans, value);
41        }
42
43        return ans;
44    }
45}
46