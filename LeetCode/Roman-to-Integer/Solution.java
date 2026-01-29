1import java.util.HashMap;
2
3public class Solution {
4    public int romanToInt(String s) {
5        HashMap<Character, Integer> map = new HashMap<>();
6
7        map.put('I', 1);
8        map.put('V', 5);
9        map.put('X', 10);
10        map.put('L', 50);
11        map.put('C', 100);
12        map.put('D', 500);
13        map.put('M', 1000);
14
15        int total = 0;
16        int prev = 0;
17
18        // Traverse from right to left
19        for (int i = s.length() - 1; i >= 0; i--) {
20            int curr = map.get(s.charAt(i));
21
22            if (curr < prev) {
23                total -= curr;
24            } else {
25                total += curr;
26            }
27
28            prev = curr;
29        }
30
31        return total;
32    }
33}
34