1class Solution {
2    public int trailingZeroes(int n) {
3        int count=0;
4        while(n>0){
5            n/=5;
6            count +=n;
7        }
8        return count;
9        
10    }
11}