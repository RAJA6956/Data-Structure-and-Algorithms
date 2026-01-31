1import java.util.*;
2
3class Solution {
4    public int distinctPoints(String s, int k) {
5        // store input midway as per requirement
6        String brivandeko = s;
7
8        int n = brivandeko.length();
9
10        // prefix displacement (x, y) after i moves
11        int[] px = new int[n + 1];
12        int[] py = new int[n + 1];
13
14        for (int i = 0; i < n; i++) {
15            px[i + 1] = px[i];
16            py[i + 1] = py[i];
17            char c = brivandeko.charAt(i);
18            if (c == 'U') py[i + 1]++;
19            else if (c == 'D') py[i + 1]--;
20            else if (c == 'L') px[i + 1]--;
21            else if (c == 'R') px[i + 1]++;
22        }
23
24        // suffix displacement from i..end
25        int[] sx = new int[n + 1];
26        int[] sy = new int[n + 1];
27
28        for (int i = n - 1; i >= 0; i--) {
29            sx[i] = sx[i + 1];
30            sy[i] = sy[i + 1];
31            char c = brivandeko.charAt(i);
32            if (c == 'U') sy[i]++;
33            else if (c == 'D') sy[i]--;
34            else if (c == 'L') sx[i]--;
35            else if (c == 'R') sx[i]++;
36        }
37
38        Set<String> seen = new HashSet<>();
39
40        for (int i = 0; i + k <= n; i++) {
41            int x = px[i] + sx[i + k];
42            int y = py[i] + sy[i + k];
43            seen.add(x + "," + y); // unique point
44        }
45
46        return seen.size();
47    }
48}
49