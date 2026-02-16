1public class Solution {
2    // You need to treat n as an unsigned value
3    public int reverseBits(int n) {
4        int result = 0;
5        for (int i = 0; i < 32; i++) {
6            int bit = (n >> i) & 1;   // extract the i-th bit
7            result |= (bit << (31 - i)); // place it in the reversed position
8        }
9        return result;
10    }
11}
12