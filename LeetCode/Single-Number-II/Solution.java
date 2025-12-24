1class Solution {
2    public int singleNumber(int[] nums) {
3        int result = 0;
4
5        for (int bit = 0; bit < 32; bit++) {
6            int count = 0;
7            for (int num : nums) {
8                if (((num >> bit) & 1) == 1) {
9                    count++;
10                }
11            }
12            if (count % 3 != 0) {
13                result |= (1 << bit);
14            }
15        }
16
17        return result;
18    }
19}
20