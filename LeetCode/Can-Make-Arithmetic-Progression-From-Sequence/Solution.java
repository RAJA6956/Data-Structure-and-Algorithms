1class Solution {
2    public boolean canMakeArithmeticProgression(int[] arr) {
3        Arrays.sort(arr);
4        int diff=arr[1]-arr[0];
5        for(int i=2;i<arr.length;i++){
6            if((arr[i]-arr[i-1])!=diff) return false;
7        }
8        return true;
9        
10    }
11}