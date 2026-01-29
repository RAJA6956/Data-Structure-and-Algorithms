1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3        int[] count = new int[26];
4        for (char c : magazine.toCharArray()) count[c - 'a']++;
5        for (char c : ransomNote.toCharArray()) {
6            if (--count[c - 'a'] < 0) return false;
7        }
8        return true;
9    }
10}
11