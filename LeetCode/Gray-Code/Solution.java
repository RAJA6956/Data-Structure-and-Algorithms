1class Solution {
2    public List<Integer> grayCode(int n) {
3        List<Integer> result = new ArrayList<>();
4        int size = 1 << n;   // 2^n
5
6        for (int i = 0; i < size; i++) {
7            result.add(i ^ (i >> 1));
8        }
9
10        return result;
11    }
12}
13