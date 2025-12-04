1// bottom up-dp approach with space optimization without usingg dp array
2class Solution {
3    public int fib(int n) {
4        if(n<=1) return n;
5        int ans=0;
6        int first=0;
7        int second=1;
8        
9        for(int i=2;i<=n;i++){
10            ans=first+second;
11            first=second;
12            second=ans;
13        }
14        return ans;
15        
16    }
17    
18}