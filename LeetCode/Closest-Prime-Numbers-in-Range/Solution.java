1class Solution {
2    public int[] closestPrimes(int left, int right) {
3        boolean[] isPrime=sieve(right);
4        int prev=-1;
5        int minDiff=Integer.MAX_VALUE;
6        int[] ans={-1,-1};
7
8        for(int i=left;i<=right;i++){
9            if(isPrime[i]){
10                if(prev !=-1){
11                    int diff=i-prev;
12                    if(diff<minDiff){
13                        minDiff=diff;
14                        ans[0]=prev;
15                        ans[1]=i;
16                    }
17                }
18                prev=i;
19            }
20        }
21        return ans;
22        
23    }
24
25    private boolean[] sieve(int n){
26        boolean[] isPrime =new boolean[n+1];
27        if(n<2) return isPrime;
28
29        for(int i=2;i<=n;i++) isPrime[i]=true;
30
31        for(int i=2;i*i<=n;i++){
32            if(isPrime[i]){
33                for(int j=i*i;j<=n;j +=i){
34                    isPrime[j]=false;
35                }
36            }
37        }
38        return isPrime;
39    }
40}