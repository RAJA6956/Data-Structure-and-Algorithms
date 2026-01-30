1public class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.isEmpty()) return 0;
4
5        int i = 0;
6        int n = s.length();
7        int sign = 1;
8        long result = 0;
9
10        // Step 1: Skip leading whitespaces
11        while (i < n && s.charAt(i) == ' ') {
12            i++;
13        }
14
15        // Step 2: Check for optional sign
16        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
17            sign = (s.charAt(i) == '-') ? -1 : 1;
18            i++;
19        }
20
21        // Step 3: Parse digits and build result
22        while (i < n && Character.isDigit(s.charAt(i))) {
23            int digit = s.charAt(i) - '0';
24            result = result * 10 + digit;
25
26            // Step 4: Clamp to 32-bit signed integer range
27            if (sign == 1 && result > Integer.MAX_VALUE) {
28                return Integer.MAX_VALUE;
29            }
30            if (sign == -1 && -result < Integer.MIN_VALUE) {
31                return Integer.MIN_VALUE;
32            }
33
34            i++;
35        }
36
37        return (int) (sign * result);
38    }
39}
40