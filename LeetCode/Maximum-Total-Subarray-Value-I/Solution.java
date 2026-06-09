1class Solution {
2    public long maxTotalValue(int[] A, int k) {
3        int min = A[0], max = A[0];
4
5        for (int n : A) {
6            min = Math.min(min, n);
7            max = Math.max(max, n);
8        }
9
10        return (long) (max - min) * k;
11    }
12}