1class Solution {
2    public int calPoints(String[] ops) {
3        Stack<Integer> stack = new Stack<>();
4        for (String op : ops) {
5            if (op.equals("+")) {
6                int top = stack.pop();
7                int newTop = top + stack.peek();
8                stack.push(top);
9                stack.push(newTop);
10            }
11            else if (op.equals("D")) {
12                stack.push(2 * stack.peek());
13            }
14            else if (op.equals("C")) {
15                               
16                stack.pop();
17            }
18            else {
19                stack.push(Integer.parseInt(op));
20            }
21        }
22        int total = 0;
23        for (int score : stack) {
24            total += score;
25        }
26         return total;
27        
28    }
29}