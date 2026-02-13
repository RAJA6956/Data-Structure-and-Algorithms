1class Solution {
2    public int findJudge(int n, int[][] trust) {
3        int[] inDegree=new int[n+1];
4        int [] outDegree=new int[n+1];
5        for(int edge[] :trust){
6            inDegree[edge[1]]++;
7            outDegree[edge[0]]++;
8        }
9        for(int i=1;i<=n;i++){
10            if(outDegree[i]==0 && inDegree[i]==n-1) return i;
11        }
12        return -1;     
13    }
14}