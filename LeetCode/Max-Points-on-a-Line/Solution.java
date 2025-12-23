1
2import java.util.*;
3
4class Solution {
5    public int maxPoints(int[][] points) {
6        int n = points.length;
7        if (n <= 2) return n;
8
9        int result = 0;
10
11        for (int i = 0; i < n; i++) {
12            Map<String, Integer> map = new HashMap<>();
13            int duplicates = 0;
14            int currMax = 0;
15
16            for (int j = i + 1; j < n; j++) {
17                int dx = points[j][0] - points[i][0];
18                int dy = points[j][1] - points[i][1];
19
20                if (dx == 0 && dy == 0) {
21                    duplicates++;
22                    continue;
23                }
24
25                int gcd = gcd(dx, dy);
26                dx /= gcd;
27                dy /= gcd;
28
29                // normalize sign
30                if (dx < 0) {
31                    dx = -dx;
32                    dy = -dy;
33                } else if (dx == 0) {
34                    dy = 1;
35                }
36
37                String slope = dy + "/" + dx;
38                map.put(slope, map.getOrDefault(slope, 0) + 1);
39                currMax = Math.max(currMax, map.get(slope));
40            }
41
42            result = Math.max(result, currMax + duplicates + 1);
43        }
44        return result;
45    }
46
47    private int gcd(int a, int b) {
48        if (b == 0) return a;
49        return gcd(b, a % b);
50    }
51}