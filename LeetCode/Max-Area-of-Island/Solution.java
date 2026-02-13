1class Solution {
2    int[] dr={-1,1,0,0};
3    int [] dc={0,0,-1,1};
4    public int maxAreaOfIsland(int[][] grid) {
5        int n=grid.length;
6        int m=grid[0].length;
7        int maxArea=0;
8        for(int i=0;i<n;i++){
9            for(int j=0;j<m;j++){
10                if(grid[i][j]==1){
11                    maxArea=Math.max(maxArea,dfs(grid,i,j));
12                }
13            }
14        }
15        return maxArea;
16
17        
18    }
19    public int dfs(int[][] grid,int row,int col){
20        int n=grid.length;
21        int m=grid[0].length;
22        if(row<0  || row>=n || col<0 || col>=m) return 0;
23        if(grid[row][col]==0) return 0;
24        grid[row][col]=0;
25        int count=1;
26        for(int i=0;i<4;i++){
27            count += dfs(grid,row +dr[i],col +dc[i]);
28        }
29        return count;
30
31
32    }
33}