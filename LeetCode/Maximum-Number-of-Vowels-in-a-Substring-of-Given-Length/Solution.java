1class Solution {
2    public int maxVowels(String s, int k) {
3        int cnt = 0, res = 0;
4        for (int i = 0; i < s.length(); i++) {
5            if (isVowel(s.charAt(i))) cnt++;
6            if (i >= k && isVowel(s.charAt(i - k))) cnt--;
7            res = Math.max(res, cnt);
8        }
9        return res;
10    }
11    private boolean isVowel(char c) {
12        return "aeiou".indexOf(c) >= 0;
13    }
14}
15