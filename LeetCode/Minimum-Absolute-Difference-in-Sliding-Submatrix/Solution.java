1class Solution {
2    public int[][] minAbsDiff(int[][] grid, int k) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int[][] result = new int[n-k+1][m-k+1];
6        if(k==1)return result;
7        for(int i=0; i<n-k+1; i++){
8            for(int j=0; j<m-k+1; j++){
9                int[] arr = new int[k*k];
10                int idx=0;
11                for(int start =i; start<i+k; start++){
12                    for(int end = j; end<j+k; end++){
13                        arr[idx++]=grid[start][end];
14                    }
15                }
16                Arrays.sort(arr);
17                int min=Integer.MAX_VALUE;
18                for(int l=1; l<k*k; l++){
19                    if(arr[l]!=arr[l-1]){
20                     min  = Math.min(min,Math.abs(arr[l]-arr[l-1]));                       
21                    }
22
23                }
24                if (min == Integer.MAX_VALUE) {
25    min = 0;
26}
27                result[i][j]=min;
28            }
29        }
30        return result;
31    }
32}