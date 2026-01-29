1public class Solution {
2    public int strStr(String haystack, String needle) {
3        int m = haystack.length();
4        int n = needle.length();
5
6        if (n == 0) return 0; // Empty needle always matches at index 0
7        if (n > m) return -1; // Needle longer than haystack
8
9        for (int i = 0; i <= m - n; i++) {
10            if (haystack.substring(i, i + n).equals(needle)) {
11                return i;
12            }
13        }
14
15        return -1;
16    }
17}
18