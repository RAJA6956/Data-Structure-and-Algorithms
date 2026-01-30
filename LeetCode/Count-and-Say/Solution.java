1class Solution {
2    public String countAndSay(int n) {
3        if (n == 1) return "1";
4        String s = "1";
5        for (int i = 2; i <= n; i++) {
6            StringBuilder sb = new StringBuilder();
7            int count = 1;
8            for (int j = 1; j < s.length(); j++) {
9                if (s.charAt(j) == s.charAt(j - 1)) count++;
10                else {
11                    sb.append(count).append(s.charAt(j - 1));
12                    count = 1;
13                }
14            }
15            sb.append(count).append(s.charAt(s.length() - 1));
16            s = sb.toString();
17        }
18        return s;
19    }
20}
21