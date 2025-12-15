1// brute force tle
2// class Solution {
3//     public long getDescentPeriods(int[] prices) {
4//         long result = 1;
5//         int len = 1;
6
7//         for (int i = 1; i < prices.length; i++) {
8//             if (prices[i - 1] - prices[i] == 1) {
9//                 len++;
10//             } else {
11//                 len = 1;
12//             }
13//             result += len;
14//         }
15//         return result;
16//     }
17// }
18
19class Solution {
20    public long getDescentPeriods(int[] prices) {
21        long result = 1;
22        int len = 1;
23
24        for (int i = 1; i < prices.length; i++) {
25            if (prices[i - 1] - prices[i] == 1) {
26                len++;
27            } else {
28                len = 1;
29            }
30            result += len;
31        }
32        return result;
33    }
34}
35
36