1class Solution {
2    public boolean checkInclusion(String s1, String s2) {
3        if (s1.length() > s2.length()) return false;
4
5        int[] count = new int[26];
6        for (char c : s1.toCharArray()) count[c - 'a']++;
7
8        int left = 0, right = 0, toMatch = s1.length();
9
10        while (right < s2.length()) {
11            if (count[s2.charAt(right++) - 'a']-- > 0) toMatch--;
12            if (toMatch == 0) return true;
13            if (right - left == s1.length() && count[s2.charAt(left++) - 'a']++ >= 0) toMatch++;
14        }
15
16        return false;
17    }
18}
19