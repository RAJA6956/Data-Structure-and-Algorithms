1class Solution {
2    public int projectionArea(int[][] grid) {
3        
4        int n=grid.length;
5        int xy=0,yz=0,zx=0;
6
7        for(int i=0;i<n;i++){
8            int maxRow=0;
9            int maxCol=0;
10            for(int j=0;j<n;j++){
11                if(grid[i][j]>0) xy++;;
12                maxRow=Math.max(maxRow,grid[i][j]);
13                maxCol=Math.max(maxCol,grid[j][i]);
14            }
15            yz +=maxRow;
16            zx +=maxCol;
17        }
18        return xy+yz+zx;
19    }
20}