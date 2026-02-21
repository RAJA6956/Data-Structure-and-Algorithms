1class Solution {
2    public boolean validPath(int n, int[][] edges, int source, int destination) {
3        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
4        for(int i=0;i<n;i++){
5            list.add(new ArrayList<>());
6        }
7        for(int[] edge: edges){
8            list.get(edge[0]).add(edge[1]);
9            list.get(edge[1]).add(edge[0]);
10
11        }
12        Queue<Integer> q=new LinkedList<>();
13        boolean[] visited=new boolean[n];
14        q.add(source);
15        visited[source]=true;
16        while(! q.isEmpty()){
17            int node=q.poll();
18            if(node==destination) return true;
19            for(int neighbour: list.get(node)){
20                if(!visited[neighbour]){
21                    visited[neighbour]=true;
22                    q.add(neighbour);
23
24                }
25            }
26        }
27        return false;
28
29        
30
31
32        
33
34        
35    }
36}