1class Solution {
2    public boolean backspaceCompare(String s, String t) {
3        return build(s).equals(build(t));
4    }
5
6    private String build(String str) {
7        StringBuilder sb = new StringBuilder();
8        for (char c : str.toCharArray()) {
9            if (c == '#') {
10                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
11            } else {
12                sb.append(c);
13            }
14        }
15        return sb.toString();
16    }
17}
18