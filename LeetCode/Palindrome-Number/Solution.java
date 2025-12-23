1class Solution {
2    public boolean isPalindrome(int x) {
3        if(x<0) return false;
4        String s=String.valueOf(x);
5        int i=0,j=s.length()-1;
6        while(i<j){
7            if(s.charAt(i) != s.charAt(j)) return false;
8            i++;
9            j--;
10        }
11        return true;
12        
13    }
14}