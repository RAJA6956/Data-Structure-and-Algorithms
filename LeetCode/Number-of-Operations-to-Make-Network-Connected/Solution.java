1class Solution {
2    int[] parent;
3    int size[];
4    public int makeConnected(int n, int[][] connections) {
5        if(connections.length<n-1) return -1;
6        parent=new int[n];
7        size=new int[n];
8        for(int i=0;i<n;i++){
9            parent[i]=i;
10            size[i]=1;
11        }
12        for(int edge[]:connections){
13            union(edge[0],edge[1]);
14        }
15
16        
17        int count=0;
18        for(int i=0;i<n;i++){
19            if(find(i) == i) count++;
20        }
21        return count-1;
22
23        
24    }
25    int find(int x){
26        if(parent[x] != x){
27            parent[x]=find(parent[x]);
28        }
29        return parent[x];
30    }
31    public void union(int x,int y){
32        int ult_p_x=find(x);
33        int ult_p_y=find(y);
34        if(ult_p_x==ult_p_y) return;
35        if(size[ult_p_x] < size[ult_p_y]){
36            parent[ult_p_x]=ult_p_y;
37            size[ult_p_y] +=size[ult_p_x];
38
39
40        }
41        else{
42            parent[ult_p_y] =ult_p_x;
43            size[ult_p_x] +=size[ult_p_y];
44
45        }
46    }
47
48}