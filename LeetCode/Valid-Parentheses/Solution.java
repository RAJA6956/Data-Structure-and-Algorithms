1import java.util.Stack;
2
3public class Solution {
4    public boolean isValid(String s) {
5        Stack<Character> stack = new Stack<>();
6        for (char c : s.toCharArray()) {
7            if (c == '(' || c == '{' || c == '[') {
8                stack.push(c);
9            } else {
10                if (stack.isEmpty()) return false;
11                char top = stack.pop();
12                if ((c == ')' && top != '(') ||
13                    (c == '}' && top != '{') ||
14                    (c == ']' && top != '[')) {
15                    return false;
16                }
17            }
18        }
19        return stack.isEmpty();
20    }
21}
22