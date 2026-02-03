1class Solution {
2    public int findJudge(int n, int[][] trust) {
3        int[] indegree = new int[n + 1];
4        int[] outdegree=new int[n+1];
5        for (int[] e : trust) {
6            indegree[e[1]]++;
7            outdegree[e[0]]++;
8        }
9
10        for (int i = 1; i <= n; i++) {
11            if (indegree[i] == n - 1  && outdegree[i] == 0) return i;
12        }
13        return -1;
14        
15        
16    }
17}
18
19