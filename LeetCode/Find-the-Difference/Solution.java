1class Solution {
2    public char findTheDifference(String s, String t) {
3        int xor = 0;
4        for (char c : s.toCharArray()) xor ^= c;
5        for (char c : t.toCharArray()) xor ^= c;
6        return (char) xor;
7    }
8}
9