1class Solution {
2    public int findCenter(int[][] edges) {
3        int e=edges.length;
4        int n=e+1;
5        int[] degree=new int[n+1];
6        for(int[] edge: edges){
7            degree[edge[0]]++;
8            degree[edge[1]]++;
9            if((degree[edge[0]])>1) return edge[0];
10            else if((degree[edge[1]])>1) return edge[1];
11        }
12        return 0;
13
14        
15    }
16}