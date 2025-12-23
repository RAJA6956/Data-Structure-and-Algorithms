1class Solution {
2    public int pivotIndex(int[] nums) {
3        int sum=0;
4        int right;
5        int left=0;
6        for(int i:nums){
7            sum +=i;
8        }
9        for(int i=0;i<nums.length;i++){
10            right=sum-left-nums[i];
11            if(left==right) return i;
12            else{
13                left +=nums[i];
14            }
15        }
16        return -1;
17        
18    }
19}