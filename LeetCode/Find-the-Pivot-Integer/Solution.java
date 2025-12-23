1class Solution {
2    public int pivotInteger(int n) {
3        int sum=n*(n+1)/2;
4        int left=0;
5        int right=sum;
6        for(int i=1;i<=n;i++){
7            if((left+i)==(sum-left)) return i;
8            left +=i;
9
10        }
11        return -1;        
12    }
13}