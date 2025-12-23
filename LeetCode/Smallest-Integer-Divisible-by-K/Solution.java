1class Solution {
2  public int smallestRepunitDivByK(int k) {
3    if (k % 10 != 1 && k % 10 != 3 && k % 10 != 7 && k % 10 != 9)
4      return -1;
5    Set<Integer> seen = new HashSet<>();
6    int n = 0;
7    for (int length = 1; length <= k; ++length) {
8      n = (n * 10 + 1) % k;
9      if (n == 0)
10        return length;
11      if (seen.contains(n))
12        return -1;
13      seen.add(n);
14    }
15
16    return -1;
17  }
18}