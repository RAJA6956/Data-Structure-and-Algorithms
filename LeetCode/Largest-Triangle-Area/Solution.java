1class Solution {
2    public double largestTriangleArea(int[][] points) {
3        double maxArea = 0.0;
4        int n = points.length;
5
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                for (int k = j + 1; k < n; k++) {
9                    maxArea = Math.max(maxArea,
10                        area(points[i], points[j], points[k]));
11                }
12            }
13        }
14        return maxArea;
15    }
16
17    private double area(int[] a, int[] b, int[] c) {
18        return 0.5 * Math.abs(
19                a[0] * (b[1] - c[1]) +
20                b[0] * (c[1] - a[1]) +
21                c[0] * (a[1] - b[1])
22        );
23    }
24}