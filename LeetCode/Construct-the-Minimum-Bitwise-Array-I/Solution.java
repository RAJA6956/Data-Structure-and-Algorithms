1import java.util.*;
2
3class Solution {
4    public int[] minBitwiseArray(List<Integer> nums) {
5
6        int n = nums.size();
7        int[] ans = new int[n];
8
9        for (int i = 0; i < n; i++) {
10            int p = nums.get(i);
11
12            // Even number cannot be formed
13            if ((p & 1) == 0) {
14                ans[i] = -1;
15                continue;
16            }
17
18            // Count trailing ones
19            int temp = p;
20            int trailingOnes = 0;
21            while ((temp & 1) == 1) {
22                trailingOnes++;
23                temp >>= 1;
24            }
25
26            // Subtract 2^(trailingOnes - 1)
27            ans[i] = p - (1 << (trailingOnes - 1));
28        }
29
30        return ans;
31    }
32}
33