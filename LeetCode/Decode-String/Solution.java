1import java.util.*;
2
3class Solution {
4    public String decodeString(String s) {
5        Stack<Integer> countStack = new Stack<>();
6        Stack<StringBuilder> stringStack = new Stack<>();
7        StringBuilder current = new StringBuilder();
8        int k = 0;
9
10        for (char c : s.toCharArray()) {
11            if (Character.isDigit(c)) {
12                k = k * 10 + (c - '0'); // build number
13            } else if (c == '[') {
14                countStack.push(k);
15                stringStack.push(current);
16                current = new StringBuilder();
17                k = 0;
18            } else if (c == ']') {
19                int repeat = countStack.pop();
20                StringBuilder decoded = stringStack.pop();
21                for (int i = 0; i < repeat; i++) {
22                    decoded.append(current);
23                }
24                current = decoded;
25            } else {
26                current.append(c);
27            }
28        }
29        return current.toString();
30    }
31}
32