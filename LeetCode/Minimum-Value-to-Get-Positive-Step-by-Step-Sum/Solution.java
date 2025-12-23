1class Solution {
2    public int minStartValue(int[] nums) {
3        int min=Integer.MAX_VALUE;
4        int sum=0;
5        for(int i:nums){
6            sum +=i;
7            min=Math.min(sum,min);
8
9        }
10        if(min >=0) return 1;
11        return Math.abs(min)+1;
12        
13    }
14}