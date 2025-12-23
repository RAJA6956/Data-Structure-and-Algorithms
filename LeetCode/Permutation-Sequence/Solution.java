1class Solution {
2    public String getPermutation(int n, int k) {
3        List<Integer> numbers = new ArrayList<>();
4        int[] fact = new int[n + 1];
5        fact[0] = 1;
6        for (int i = 1; i <= n; i++) {
7            fact[i] = fact[i - 1] * i;
8            numbers.add(i);
9        }
10        k--;
11
12        StringBuilder result = new StringBuilder();
13        for (int i = n; i >= 1; i--) {
14            int index = k / fact[i - 1];
15            result.append(numbers.get(index));
16            numbers.remove(index);
17            k %= fact[i - 1];
18        }
19        return result.toString();
20    }
21}
22