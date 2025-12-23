1class Solution {
2    public boolean isUgly(int n) {
3        if(n<=0) return false;
4        int[] primes={2,3,5};
5        for(int p :primes){
6            while(n%p==0){
7                n /=p;
8            }
9        }
10        return n==1;
11        
12        
13    }
14}