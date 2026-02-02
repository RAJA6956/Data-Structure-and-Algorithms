1import java.util.*;
2
3class Solution {
4    public int calculate(String s) {
5        int n = s.length();
6        int result = 0;
7        int sign = 1; // current sign (+1 or -1)
8        Stack<Integer> stack = new Stack<>();
9        
10        for (int i = 0; i < n; i++) {
11            char c = s.charAt(i);
12
13            if (Character.isDigit(c)) {
14                int num = 0;
15                while (i < n && Character.isDigit(s.charAt(i))) {
16                    num = num * 10 + (s.charAt(i) - '0');
17                    i++;
18                }
19                i--; // step back after overshooting
20                result += sign * num;
21            } else if (c == '+') {
22                sign = 1;
23            } else if (c == '-') {
24                sign = -1;
25            } else if (c == '(') {
26                // Push current result and sign
27                stack.push(result);
28                stack.push(sign);
29                // Reset for new subexpression
30                result = 0;
31                sign = 1;
32            } else if (c == ')') {
33                // Complete subexpression
34                int prevSign = stack.pop();
35                int prevResult = stack.pop();
36                result = prevResult + prevSign * result;
37            }
38        }
39        return result;
40    }
41}
42