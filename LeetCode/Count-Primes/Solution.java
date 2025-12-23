1class Solution {
2    public int countPrimes(int n) {
3        if(n<=2) return 0;
4
5        boolean[] isPrime=new boolean[n];
6        for(int i=2;i<n;i++){
7            isPrime[i]=true;
8        }
9        for(int i=2;i*i<n;i++){
10            if(isPrime[i]){
11                for(int j=i*i;j<n;j +=i){
12                    isPrime[j]=false;
13                }
14            }
15        }
16        int count=0;
17        for(int i=2;i<n;i++){
18            if(isPrime[i]) count++;
19        }
20        return count;
21
22        
23    }
24}