1class Solution {
2    public boolean isNumber(String s) {
3        s = s.trim();
4        boolean num = false, dot = false, exp = false;
5        
6        for (int i = 0; i < s.length(); i++) {
7            char c = s.charAt(i);
8            
9            if (Character.isDigit(c)) {
10                num = true;
11            } else if (c == '.') {
12                if (dot || exp) return false;
13                dot = true;
14            } else if (c == 'e' || c == 'E') {
15                if (exp || !num) return false;
16                exp = true;
17                num = false; // must have a number after e
18            } else if (c == '+' || c == '-') {
19                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
20            } else return false;
21        }
22        return num;
23    }
24}
25