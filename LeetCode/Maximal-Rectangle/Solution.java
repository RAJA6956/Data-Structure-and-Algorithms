1import java.util.Stack;
2class Solution {
3    public int maximalRectangle(char[][] matrix) {
4        if (matrix.length == 0) return 0;
5        int m = matrix.length, n = matrix[0].length;
6        int[] heights = new int[n];
7        int maxArea = 0;
8        for (int i = 0; i < m; i++) {
9            for (int j=0; j < n; j++) {
10                if (matrix[i][j]== '1') {
11                    heights[j] += 1;
12                } else {
13                    heights[j] = 0;
14                }
15            }
16            maxArea = Math.max(maxArea, largestRectangleArea(heights));
17        }
18        return maxArea;
19    }
20    private int largestRectangleArea(int[] heights) {
21        Stack<Integer> stack = new Stack<>();
22        int maxArea = 0;
23        int n = heights.length;
24        for (int i = 0; i <= n; i++) {
25            int h = (i == n) ? 0 : heights[i];
26            while (!stack.isEmpty() && h < heights[stack.peek()]) {
27                int height = heights[stack.pop()];
28                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
29                maxArea = Math.max(maxArea, height * width);
30            }
31            stack.push(i);
32        }
33        return maxArea;
34    }
35}
36