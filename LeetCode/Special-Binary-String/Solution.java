1import java.util.*;
2
3class Solution {
4    public String makeLargestSpecial(String s) {
5        int count = 0;
6        int i = 0;
7        List<String> res = new ArrayList<>();
8
9        for (int j = 0; j < s.length(); j++) {
10            if (s.charAt(j) == '1') {
11                count++;
12            } else {
13                count--;
14            }
15
16            if (count == 0) {
17                String inner = makeLargestSpecial(s.substring(i + 1, j));
18                res.add("1" + inner + "0");
19                i = j + 1;
20            }
21        }
22
23        Collections.sort(res, Collections.reverseOrder());
24
25        StringBuilder ans = new StringBuilder();
26        for (String str : res) {
27            ans.append(str);
28        }
29
30        return ans.toString();
31    }
32}