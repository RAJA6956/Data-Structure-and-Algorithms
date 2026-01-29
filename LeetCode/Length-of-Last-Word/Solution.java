1class Solution {
2    public int lengthOfLastWord(String s) {
3        s = s.trim();
4        int lastSpace = s.lastIndexOf(' ');
5        return s.length() - lastSpace - 1;
6    }
7}
8