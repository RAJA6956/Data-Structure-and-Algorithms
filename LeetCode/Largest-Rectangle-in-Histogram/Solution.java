1import java.util.*;
2
3class Solution {
4    public int largestRectangleArea(int[] heights) {
5        int n = heights.length;
6        int[] left = new int[n];
7        int[] right = new int[n];
8        Stack<Integer> stack = new Stack<>();
9
10        // Previous Smaller
11        for (int i = 0; i < n; i++) {
12            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
13            left[i] = stack.isEmpty() ? -1 : stack.peek();
14            stack.push(i);
15        }
16
17        stack.clear();
18
19        // Next Smaller
20        for (int i = n - 1; i >= 0; i--) {
21            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
22            right[i] = stack.isEmpty() ? n : stack.peek();
23            stack.push(i);
24        }
25
26        int maxArea = 0;
27        for (int i = 0; i < n; i++) {
28            int width = right[i] - left[i] - 1;
29            maxArea = Math.max(maxArea, width * heights[i]);
30        }
31
32        return maxArea;
33    }
34}
35