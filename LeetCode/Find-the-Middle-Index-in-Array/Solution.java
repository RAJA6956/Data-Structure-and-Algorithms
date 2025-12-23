1class Solution {
2    public int findMiddleIndex(int[] nums) {
3        int totalSum=0;
4        int left=0;
5        int right;
6        for(int i:nums){
7            totalSum +=i;
8        }
9
10        for(int i=0;i<nums.length;i++){
11            right=totalSum-left-nums[i];
12            if(left==right) return i;
13            else{
14                left += nums[i];
15            }
16
17        }
18        return -1;
19        
20    }
21}