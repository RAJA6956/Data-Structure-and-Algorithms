1import java.util.*;
2
3class Solution {
4    public int minimumPairRemoval(int[] nums) {
5
6        List<Integer> list = new ArrayList<>();
7        for (int x : nums) list.add(x);
8
9        int operations = 0;
10
11        while (!isNonDecreasing(list)) {
12
13            int minSum = Integer.MAX_VALUE;
14            int index = 0;
15
16            // Find adjacent pair with minimum sum
17            for (int i = 0; i < list.size() - 1; i++) {
18                int sum = list.get(i) + list.get(i + 1);
19                if (sum < minSum) {
20                    minSum = sum;
21                    index = i;
22                }
23            }
24
25            // Replace the pair with their sum
26            list.set(index, minSum);
27            list.remove(index + 1);
28
29            operations++;
30        }
31
32        return operations;
33    }
34
35    private boolean isNonDecreasing(List<Integer> list) {
36        for (int i = 1; i < list.size(); i++) {
37            if (list.get(i) < list.get(i - 1)) {
38                return false;
39            }
40        }
41        return true;
42    }
43}
44